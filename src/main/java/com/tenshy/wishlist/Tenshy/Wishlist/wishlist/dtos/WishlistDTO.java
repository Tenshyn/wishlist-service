package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.dtos;

import com.tenshy.wishlist.Tenshy.Wishlist.product.dtos.ProductDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.user.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class WishlistDTO {

    private UserDTO userDTO;
    private ProductDTO productDTO;

}
