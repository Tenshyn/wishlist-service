package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl;

import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.WishlistId;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.repositories.WishlistRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.ICheckIfProductExistsOnWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckIfProductExistsOnWishlistServiceImpl implements ICheckIfProductExistsOnWishlistService {

    private final WishlistRepository wishlistRepository;

    @Autowired
    public CheckIfProductExistsOnWishlistServiceImpl(final WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public boolean execute(UUID userId, UUID productId) {
        final WishlistId wishlistId = new WishlistId(userId, productId);
        return wishlistRepository.existsById(wishlistId);
    }

}
