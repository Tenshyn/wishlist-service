package com.tenshy.wishlist.Tenshy.Wishlist.user.services;

import com.tenshy.wishlist.Tenshy.Wishlist.user.dtos.UserDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;

public interface ICreateUserService {

    User execute(UserDTO userDTO);

}
