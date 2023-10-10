package com.tenshy.wishlist.Tenshy.Wishlist.product.mappers;

import com.tenshy.wishlist.Tenshy.Wishlist.product.dtos.ProductDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.http.views.ProductView;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {

    public static Product mapper(final ProductDTO productDTO) {
        return Product.create(productDTO.getId(), productDTO.getName(),
                productDTO.getLink(), productDTO.getPrice());
    }

    public static ProductDTO mapper(final Product product) {
        return ProductDTO.create(product.getId(), product.getName(),
                product.getLink(), product.getPrice());
    }

}
