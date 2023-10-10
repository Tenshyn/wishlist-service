package com.tenshy.wishlist.Tenshy.Wishlist.user.mappers;

import com.tenshy.wishlist.Tenshy.Wishlist.user.dtos.UserDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static User mapper(final UserDTO userDTO) {
        return User.create(userDTO.getId(), userDTO.getName(),
                userDTO.getEmail());
    }

}
