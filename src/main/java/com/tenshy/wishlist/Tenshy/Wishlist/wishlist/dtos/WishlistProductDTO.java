package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.dtos;

import com.tenshy.wishlist.Tenshy.Wishlist.product.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class WishlistProductDTO {

    private UUID userId;
    private UUID productId;

}
