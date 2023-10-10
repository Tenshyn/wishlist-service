package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services;

import java.util.UUID;

public interface IRemoveProductFromWishlistService {
    void execute(UUID userId, UUID productId);
}
