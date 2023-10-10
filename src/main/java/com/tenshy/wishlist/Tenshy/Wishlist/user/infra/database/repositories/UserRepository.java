package com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.repositories;

import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
}
