package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.shared.helpers.CreateFakeEntitiesHelper;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.repositories.UserRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.user.services.impl.CheckIfUserExistsServiceImpl;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.TooManyProductsInWishlistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserAlreadyWishlistProduct;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserDoesNotExistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserDoesNotHaveProductOnWishlistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.WishlistId;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.repositories.WishlistRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl.AddProductToWishlistServiceImpl;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl.RemoveProductFromWishlistServiceImpl;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl.RetrieveAllWishlistProductsByServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RemoveProductFromWishlistTest {

    @Mock
    private UserRepository userMockRepository;
    @Mock
    private WishlistRepository wishlistMockRepository;

    private RemoveProductFromWishlistServiceImpl removeProductFromWishlistService;

    private final UUID userID = UUID.randomUUID();
    private final UUID productId = UUID.randomUUID();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        final CheckIfUserExistsServiceImpl checkIfUserExistsService = new CheckIfUserExistsServiceImpl(userMockRepository);
        this.removeProductFromWishlistService = new RemoveProductFromWishlistServiceImpl(wishlistMockRepository, checkIfUserExistsService);

        doNothing().when(wishlistMockRepository).deleteById(any());
        when(userMockRepository.existsById(userID)).thenReturn(true);
        when(wishlistMockRepository.existsById(any())).thenReturn(true);
    }


    @Test
    public void shouldRemoveProductFromUserWishlist() {
        this.removeProductFromWishlistService.execute(userID, productId);

        verify(wishlistMockRepository, times(1)).deleteById(any());
    }


    @Test
    public void shouldThrowExceptionIfUserDoesNotExist() {
        final UUID fakeUserId = UUID.randomUUID();
        when(userMockRepository.existsById(fakeUserId)).thenReturn(false);

        final Exception exception = assertThrows(UserDoesNotExistException.class, () -> {
            this.removeProductFromWishlistService.execute(fakeUserId, productId);
        });

        assertEquals(exception.getClass(), UserDoesNotExistException.class);
    }

    @Test
    public void shouldThrowExceptionIfUserDoesNotHaveItemOnList() {
        when(wishlistMockRepository.existsById(any())).thenReturn(false);
        final Exception exception = assertThrows(UserDoesNotHaveProductOnWishlistException.class, () -> {
            this.removeProductFromWishlistService.execute(userID, productId);
        });

        assertEquals(exception.getClass(), UserDoesNotHaveProductOnWishlistException.class);
    }

}
