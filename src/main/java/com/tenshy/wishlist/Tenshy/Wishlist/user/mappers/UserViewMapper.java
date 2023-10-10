package com.tenshy.wishlist.Tenshy.Wishlist.user.mappers;

import com.tenshy.wishlist.Tenshy.Wishlist.user.dtos.UserDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.http.views.UserView;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserViewMapper {

    public static UserView mapper(final User user) {
        return UserView.create(user.getId(), user.getName(),
                user.getEmail());
    }
    
}
