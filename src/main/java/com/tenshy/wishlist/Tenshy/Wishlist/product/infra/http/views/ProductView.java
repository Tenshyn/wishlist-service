package com.tenshy.wishlist.Tenshy.Wishlist.product.infra.http.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
public class ProductView {

    private String id;
    private String name;
    private String link;
    private Double price;

}
