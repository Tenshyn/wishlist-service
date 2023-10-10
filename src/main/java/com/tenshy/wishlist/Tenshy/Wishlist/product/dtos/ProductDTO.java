package com.tenshy.wishlist.Tenshy.Wishlist.product.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class ProductDTO {

    private UUID id;
    private String name;
    private String link;
    private Double price;

}
