package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.WishlistId;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.repositories.WishlistRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.IAddProductToWishlistService;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.IRetrieveAllWishlistProductsByService;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.validations.WishlistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddProductToWishlistServiceImpl implements IAddProductToWishlistService {

    private final WishlistRepository wishlistRepository;
    private final IRetrieveAllWishlistProductsByService retrieveAllWishlistProductsByService;

    @Autowired
    public AddProductToWishlistServiceImpl(final WishlistRepository wishlistRepository,
                                           final IRetrieveAllWishlistProductsByService retrieveAllWishlistProductsByService) {
        this.wishlistRepository = wishlistRepository;
        this.retrieveAllWishlistProductsByService = retrieveAllWishlistProductsByService;
    }

    @Override
    public Wishlist execute(final UUID userId, final UUID productId) {
        final WishlistId wishlistId = new WishlistId(userId, productId);
        this.checkUserWishlist(wishlistId);

        final Wishlist wishlistToSave = Wishlist.from(wishlistId);
        return wishlistRepository.save(wishlistToSave);
    }

    private void checkUserWishlist(final WishlistId wishlistId) {
        final List<Product> products = this.retrieveAllWishlistProductsByService.execute(wishlistId.getUserId());
        WishlistValidator.check(wishlistId, products);
    }

}
