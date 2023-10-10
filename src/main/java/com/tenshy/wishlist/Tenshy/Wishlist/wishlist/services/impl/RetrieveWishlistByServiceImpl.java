package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.impl;

import com.tenshy.wishlist.Tenshy.Wishlist.user.services.ICheckIfUserExistsService;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.entitites.Wishlist;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.database.repositories.WishlistRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.services.IRetrieveWishlistByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RetrieveWishlistByServiceImpl implements IRetrieveWishlistByService {

    private final WishlistRepository wishlistRepository;
    private final ICheckIfUserExistsService checkIfUserExistsService;

    @Autowired
    public RetrieveWishlistByServiceImpl(final WishlistRepository wishlistRepository,
                                        final ICheckIfUserExistsService checkIfUserExistsService) {
        this.wishlistRepository = wishlistRepository;
        this.checkIfUserExistsService = checkIfUserExistsService;
    }

    @Override
    public List<Wishlist> execute(final UUID userId) {
        this.checkIfUserExistsService.execute(userId);
        return wishlistRepository.findAllByUserId(userId);
    }
}
