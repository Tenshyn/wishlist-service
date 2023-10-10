package com.tenshy.wishlist.Tenshy.Wishlist.product.mappers;

import com.tenshy.wishlist.Tenshy.Wishlist.product.dtos.ProductDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.http.views.ProductView;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductViewMapper {

    public static ProductView mapper(final Product product) {
        return ProductView.create(product.getId().toString(), product.getName(),
                product.getLink(), product.getPrice());
    }

}
