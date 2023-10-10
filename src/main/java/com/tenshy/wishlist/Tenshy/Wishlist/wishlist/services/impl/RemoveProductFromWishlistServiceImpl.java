package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl;

import com.tenshy.wishlist.Tenshy.Wishlist.user.services.ICheckIfUserExistsService;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserDoesNotExistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserDoesNotHaveProductOnWishlistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.WishlistId;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.repositories.WishlistRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.IRemoveProductFromWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RemoveProductFromWishlistServiceImpl implements IRemoveProductFromWishlistService {

    private final WishlistRepository wishlistRepository;
    private final ICheckIfUserExistsService checkIfUserExistsService;

    @Autowired
    public RemoveProductFromWishlistServiceImpl(final WishlistRepository wishlistRepository,
                                                final ICheckIfUserExistsService checkIfUserExistsService) {
        this.wishlistRepository = wishlistRepository;
        this.checkIfUserExistsService = checkIfUserExistsService;
    }

    @Override
    public void execute(final UUID userId, UUID productId) {
        final WishlistId wishlistId = new WishlistId(userId, productId);
        this.checkUserWishlist(wishlistId);
        wishlistRepository.deleteById(wishlistId);
    }

    private void checkUserWishlist(final WishlistId wishlistId) {
        this.checkIfUserExistsService.execute(wishlistId.getUserId());

        final boolean userDoesNotHaveProductOnWishlist = !wishlistRepository.existsById(wishlistId);
        if(userDoesNotHaveProductOnWishlist) {
            throw new UserDoesNotHaveProductOnWishlistException("User does not have this product on his wishlist");
        }
    }

}
