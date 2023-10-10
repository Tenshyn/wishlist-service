package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services;

import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;

import java.util.List;
import java.util.UUID;

public interface IRetrieveWishlistByService {

    List<Wishlist> execute(UUID userId);

}
