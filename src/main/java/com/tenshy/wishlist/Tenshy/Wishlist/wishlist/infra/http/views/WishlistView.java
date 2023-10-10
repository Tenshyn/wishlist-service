package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.http.views;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.http.views.ProductView;
import com.tenshy.wishlist.Tenshy.Wishlist.user.dtos.UserDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.http.views.UserView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class WishlistView {

    private UserView user;
    private ProductView product;
}
