package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services;

import java.util.UUID;

public interface ICheckIfProductExistsOnWishlistService {
    boolean execute(UUID userId, UUID productId);
}
