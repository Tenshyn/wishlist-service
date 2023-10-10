package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services;

import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;

import java.util.UUID;

public interface IAddProductToWishlistService {
    Wishlist execute(UUID userId, UUID productId);
}
