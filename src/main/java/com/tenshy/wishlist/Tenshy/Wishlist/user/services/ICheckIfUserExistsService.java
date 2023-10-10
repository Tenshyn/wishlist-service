package com.tenshy.wishlist.Tenshy.Wishlist.user.services;

import java.util.UUID;

public interface ICheckIfUserExistsService {

    void execute(UUID userId);

}
