package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WishlistId {

    @Column(name = "ww_user_id", nullable = false)
    private UUID userId;
    @Column(name = "ww_product_id")
    private UUID productId;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof final WishlistId compareId)) return false;

        return Objects.equals(this.getUserId(), compareId.getUserId())
                && Objects.equals(this.getProductId(), compareId.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getProductId());
    }

}
