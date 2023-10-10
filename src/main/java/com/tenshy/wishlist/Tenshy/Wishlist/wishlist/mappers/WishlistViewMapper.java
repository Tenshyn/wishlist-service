package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.mappers;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.http.views.ProductView;
import com.tenshy.wishlist.Tenshy.Wishlist.product.mappers.ProductViewMapper;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.http.views.UserView;
import com.tenshy.wishlist.Tenshy.Wishlist.user.mappers.UserViewMapper;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.http.views.WishlistView;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WishlistViewMapper {

    public static WishlistView mapper(final Wishlist wishlist) {
        final UserView userView = UserViewMapper.mapper(wishlist.getUser());
        final ProductView productView = ProductViewMapper.mapper(wishlist.getProduct());

        return WishlistView.create(userView, productView);
    }

}
