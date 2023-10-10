package com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.repositories;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {

    List<Product> findAll();

}
