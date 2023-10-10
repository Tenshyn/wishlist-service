package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.shared.helpers.CreateFakeEntitiesHelper;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.repositories.UserRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.user.services.impl.CheckIfUserExistsServiceImpl;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.TooManyProductsInWishlistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserAlreadyWishlistProduct;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserDoesNotExistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.WishlistId;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.repositories.WishlistRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl.AddProductToWishlistServiceImpl;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl.RetrieveAllWishlistProductsByServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RetrieveAllWishlistProductsTest {

    @Mock
    private UserRepository userMockRepository;
    @Mock
    private WishlistRepository wishlistMockRepository;

    private RetrieveAllWishlistProductsByServiceImpl retrieveAllWishlistProductsByService;

    private final UUID userID = UUID.randomUUID();
    private final List<Product> wishlistedProducts = CreateFakeEntitiesHelper.createManyProducts(8);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        final CheckIfUserExistsServiceImpl checkIfUserExistsService = new CheckIfUserExistsServiceImpl(userMockRepository);
        this.retrieveAllWishlistProductsByService = new RetrieveAllWishlistProductsByServiceImpl(wishlistMockRepository, checkIfUserExistsService);

        final List<Wishlist> wishlists = wishlistedProducts.stream().
                map(product -> {
                    final WishlistId wishlistId = new WishlistId(userID, product.getId());
                    return Wishlist.from(wishlistId);
                }).toList();

        when(wishlistMockRepository.findAllByUserId(userID)).thenReturn(wishlists);
        when(userMockRepository.existsById(userID)).thenReturn(true);
    }


    @Test
    public void shouldRetrieveAllWishlistProducts() {
        final List<Product> products = this.retrieveAllWishlistProductsByService.execute(userID);

        assertEquals(products.size(), wishlistedProducts.size());
    }

    @Test
    public void shouldThrowExceptionIfUserDoesNotExist() {
        final UUID fakeUserId = UUID.randomUUID();
        when(userMockRepository.existsById(fakeUserId)).thenReturn(false);

        final Exception exception = assertThrows(UserDoesNotExistException.class, () -> {
            this.retrieveAllWishlistProductsByService.execute(fakeUserId);
        });

        assertEquals(exception.getClass(), UserDoesNotExistException.class);
    }

}
