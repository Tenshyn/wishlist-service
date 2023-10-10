package com.tenshy.wishlist.Tenshy.Wishlist.product.infra.http.controllers;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
DISCLAIMER: THIS CONTROLLER IS MEANT TO BE USED ONLY FOR TESTING
HENCE NO VALIDATIONS, TREATED EXCEPTIONS OR SERVICES
 */

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping
    public ResponseEntity<List<Product>> show() {
        final List<Product> products = this.productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        final Product productSaved = this.productRepository.save(product);
        return ResponseEntity.status(201).body(productSaved);
    }


}
