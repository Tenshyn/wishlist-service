package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;

import java.util.List;
import java.util.UUID;

public interface IRetrieveAllWishlistProductsByService {

    List<Product> execute(UUID userId);

}
