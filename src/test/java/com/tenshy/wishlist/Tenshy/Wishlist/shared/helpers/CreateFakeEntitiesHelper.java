package com.tenshy.wishlist.Tenshy.Wishlist.shared.helpers;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.WishlistId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateFakeEntitiesHelper {

    public static Wishlist createFakeWishlist(final WishlistId wishlistId) {
        return Wishlist.create(
                wishlistId,
                CreateFakeEntitiesHelper.createFakeUser(wishlistId.getUserId()),
                CreateFakeEntitiesHelper.createFakeProduct(wishlistId.getProductId())
        );
    }

    public static User createFakeUser(final UUID userId) {
        final User user = new User();
        user.setId(userId);
        user.setName("Tenshy Test");
        user.setEmail("tenshy_test@test.com");

        return user;
    }

    public static Product createFakeProduct(final UUID productId) {
        final Product product = new Product();
        product.setId(productId);
        product.setLink("https://www.fakestore.com.br/fake-prod");
        product.setName("Fake Prod");
        product.setPrice(50.0);

        return product;
    }

    public static List<Product> createManyProducts(int productsCounter) {
        final List<Product> products = new ArrayList<>();

        for(int i = 0; i < productsCounter; i ++) {
            final Product product = new Product();
            product.setId(UUID.randomUUID());
            product.setLink("https://www.fakestore.com.br/fake-prod" + i);
            product.setName("Fake Prod " + i);
            product.setPrice(50.0);

            products.add(product);
        }

        return products;
    }


}
