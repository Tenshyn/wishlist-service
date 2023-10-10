package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "wl_wishlist")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class Wishlist {

    @EmbeddedId
    private WishlistId wishlistId;

    @OneToOne
    @JoinColumn(name = "ww_user_id", insertable = false, updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "ww_product_id", insertable = false, updatable = false)
    private Product product;

    public static Wishlist from(final WishlistId wishlistId) {
        final User user = new User().setId(wishlistId.getUserId());
        final Product product = new Product().setId(wishlistId.getProductId());
        return Wishlist.create(wishlistId, user, product);
    }

}
