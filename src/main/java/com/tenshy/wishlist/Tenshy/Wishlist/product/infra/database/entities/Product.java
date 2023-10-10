package com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Entity(name = "wl_product")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
@Accessors(chain = true)
public class Product {

    @Id
    @Column(name = "wp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "wp_name")
    private String name;
    @Column(name = "wp_link")
    private String link;
    @Column(name = "wp_price")
    private Double price;

}
