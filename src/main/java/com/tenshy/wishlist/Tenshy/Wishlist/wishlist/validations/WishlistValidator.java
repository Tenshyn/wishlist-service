package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.validations;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.TooManyProductsInWishlistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserAlreadyWishlistProduct;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.WishlistId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WishlistValidator {

    public static void check(final WishlistId wishlistId, final List<Product> products) {
        WishlistValidator.checkProductsSize(wishlistId, products);
        WishlistValidator.checkProductAvailability(wishlistId, products);
    }

    private static void checkProductAvailability(final WishlistId wishlistId, final List<Product> wishlistProducts) {
        final boolean userAlreadyWishlistProduct = wishlistProducts.stream()
                .anyMatch(product -> product.getId().equals(wishlistId.getProductId()));

        if(userAlreadyWishlistProduct)
            throw new UserAlreadyWishlistProduct("you have already put this product on your wishlist");
    }

    private static void checkProductsSize(final WishlistId wishlistId, final List<Product> wishlistProducts) {
        final boolean hasTooManyProducts = wishlistProducts.size() >= 20;
        if(hasTooManyProducts)
            throw new TooManyProductsInWishlistException("You can have a maximum of 20 products in your wishlist");
    }

}
