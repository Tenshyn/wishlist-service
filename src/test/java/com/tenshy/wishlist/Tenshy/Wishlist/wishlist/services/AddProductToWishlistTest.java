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
public class AddProductToWishlistTest {

    @Mock
    private UserRepository userMockRepository;
    @Mock
    private WishlistRepository wishlistMockRepository;

    private AddProductToWishlistServiceImpl addProductToWishlistService;

    private final UUID userID = UUID.randomUUID();
    private final UUID productId = UUID.randomUUID();
    private final WishlistId wishlistId = new WishlistId(userID, productId);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        final CheckIfUserExistsServiceImpl checkIfUserExistsService = new CheckIfUserExistsServiceImpl(userMockRepository);
        final RetrieveAllWishlistProductsByServiceImpl retrieveAllWishlistProductsByService = new RetrieveAllWishlistProductsByServiceImpl(wishlistMockRepository, checkIfUserExistsService);
        this.addProductToWishlistService = new AddProductToWishlistServiceImpl(wishlistMockRepository, retrieveAllWishlistProductsByService);


        when(wishlistMockRepository.save(any(Wishlist.class))).thenReturn(Wishlist.from(wishlistId));
        when(userMockRepository.existsById(userID)).thenReturn(true);
    }


    @Test
    public void shouldAddProductToUserWishlist() {
        when(wishlistMockRepository.findAllByUserId(userID)).thenReturn(Collections.emptyList());
        final Wishlist wishlist = this.addProductToWishlistService.execute(userID, productId);

        assertEquals(wishlist.getProduct().getId(), productId);
        assertEquals(wishlist.getUser().getId(), userID);
    }

    @Test
    public void shouldThrowExceptionIfWishlistIsTooBig() {
        final List<Product> products = CreateFakeEntitiesHelper.createManyProducts(20);
        final List<Wishlist> wishlists = products.stream().map(product -> {
            final WishlistId wishlistId = new WishlistId(userID, product.getId());
            return Wishlist.from(wishlistId);
        }).toList();

        when(wishlistMockRepository.findAllByUserId(userID)).thenReturn(wishlists);
        final Exception exception = assertThrows(TooManyProductsInWishlistException.class, () -> {
            this.addProductToWishlistService.execute(userID, productId);
        });

        assertEquals(exception.getClass(), TooManyProductsInWishlistException.class);
    }

    @Test
    public void shouldThrowExceptionIfUserDoesNotExist() {
        final UUID fakeUserId = UUID.randomUUID();
        when(userMockRepository.existsById(fakeUserId)).thenReturn(false);

        final Exception exception = assertThrows(UserDoesNotExistException.class, () -> {
            this.addProductToWishlistService.execute(fakeUserId, productId);
        });

        assertEquals(exception.getClass(), UserDoesNotExistException.class);
    }

    @Test
    public void shouldThrowExceptionIfUserAlreadyHaveItemOnList() {
        final List<Wishlist> wishlists = List.of(CreateFakeEntitiesHelper.createFakeWishlist(wishlistId));
        when(wishlistMockRepository.findAllByUserId(userID)).thenReturn(wishlists);

        final Exception exception = assertThrows(UserAlreadyWishlistProduct.class, () -> {
            this.addProductToWishlistService.execute(userID, productId);
        });

        assertEquals(exception.getClass(), UserAlreadyWishlistProduct.class);
    }

}
