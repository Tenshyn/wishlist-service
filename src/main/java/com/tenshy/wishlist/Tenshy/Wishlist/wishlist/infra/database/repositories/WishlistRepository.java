package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.repositories;

import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.WishlistId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, WishlistId> {

    List<Wishlist> findAllByUserId(UUID userId);

}
