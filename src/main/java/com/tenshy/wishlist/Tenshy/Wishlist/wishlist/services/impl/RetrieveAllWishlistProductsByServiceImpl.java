package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl;

import com.tenshy.wishlist.Tenshy.Wishlist.product.infra.database.entities.Product;
import com.tenshy.wishlist.Tenshy.Wishlist.user.services.ICheckIfUserExistsService;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.repositories.WishlistRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.IRetrieveAllWishlistProductsByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RetrieveAllWishlistProductsByServiceImpl implements IRetrieveAllWishlistProductsByService {

    private final WishlistRepository wishlistRepository;
    private final ICheckIfUserExistsService checkIfUserExistsService;

    @Autowired
    public RetrieveAllWishlistProductsByServiceImpl(final WishlistRepository wishlistRepository,
                                                    final ICheckIfUserExistsService checkIfUserExistsService) {
        this.wishlistRepository = wishlistRepository;
        this.checkIfUserExistsService = checkIfUserExistsService;
    }

    @Override
    public List<Product> execute(final UUID userId) {
        this.checkIfUserExistsService.execute(userId);

        final List<Wishlist> wishlists = this.wishlistRepository.findAllByUserId(userId);
        return wishlists.stream().map(Wishlist::getProduct).toList();
    }
}
