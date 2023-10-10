package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.http.controllers;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.http.views.ProductView;
import com.tenshy.wishlist.Tenshy.Wishlist.product.mappers.ProductViewMapper;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.dtos.WishlistProductDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.http.views.WishlistView;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.mappers.WishlistViewMapper;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("wishlist")
public class WishlistController {

    private final IRetrieveWishlistByService retrieveWishlistByService;
    private final IAddProductToWishlistService addProductToWishlistService;
    private final IRemoveProductFromWishlistService removeProductFromWishlistService;
    private final IRetrieveAllWishlistProductsByService retrieveAllWishlistProductsByService;
    private final ICheckIfProductExistsOnWishlistService checkIfProductExistsOnWishlistService;

    @Autowired
    public WishlistController(final IRetrieveWishlistByService retrieveWishlistByService,
                              final IAddProductToWishlistService addProductToWishlistService,
                              final IRemoveProductFromWishlistService removeProductFromWishlistService,
                              final IRetrieveAllWishlistProductsByService retrieveAllWishlistProductsByService,
                              final ICheckIfProductExistsOnWishlistService checkIfProductExistsOnWishlistService) {
        this.retrieveWishlistByService = retrieveWishlistByService;
        this.addProductToWishlistService = addProductToWishlistService;
        this.removeProductFromWishlistService = removeProductFromWishlistService;
        this.retrieveAllWishlistProductsByService = retrieveAllWishlistProductsByService;
        this.checkIfProductExistsOnWishlistService = checkIfProductExistsOnWishlistService;
    }

    @RequestMapping
    public ResponseEntity<List<Wishlist>> show(@RequestParam String userId) {
        final List<Wishlist> wishlist = this.retrieveWishlistByService.execute(UUID.fromString(userId));
        return ResponseEntity.ok(wishlist);
    }

    @RequestMapping("products")
    public ResponseEntity<List<ProductView>> showProducts(@RequestParam String userId) {
        final List<Product> products = this.retrieveAllWishlistProductsByService.execute(UUID.fromString(userId));
        final List<ProductView> views = products.stream().map(ProductViewMapper::mapper).toList();
        return ResponseEntity.ok(views);
    }

    @RequestMapping("products/exists")
    public ResponseEntity<Boolean> showProducts(@RequestParam String userId, @RequestParam String productId) {
        final Boolean doesProductExists = this.checkIfProductExistsOnWishlistService.execute(UUID.fromString(userId), UUID.fromString(productId));
        return ResponseEntity.ok(doesProductExists);
    }

    @PostMapping("products")
    public ResponseEntity<WishlistView> add(@RequestBody WishlistProductDTO wishlistProductDTO) {
        final Wishlist wishlist = this.addProductToWishlistService.execute(wishlistProductDTO.getUserId(), wishlistProductDTO.getProductId());
        return ResponseEntity.status(201).body(WishlistViewMapper.mapper(wishlist));
    }

    @DeleteMapping("products")
    public ResponseEntity<WishlistView> remove(@RequestBody WishlistProductDTO wishlistProductDTO) {
        this.removeProductFromWishlistService.execute(wishlistProductDTO.getUserId(), wishlistProductDTO.getProductId());
        return ResponseEntity.noContent().build();
    }

}
