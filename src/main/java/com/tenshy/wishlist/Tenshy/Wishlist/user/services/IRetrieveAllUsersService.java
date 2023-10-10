package com.tenshy.wishlist.Tenshy.Wishlist.user.services;

import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;

import java.util.List;
import java.util.UUID;

public interface IRetrieveAllUsersService {

    List<User> execute();

}
