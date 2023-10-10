package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions;

public class UserDoesNotHaveProductOnWishlistException extends RuntimeException {

    public UserDoesNotHaveProductOnWishlistException(String msg) {
        super(msg);
    }

}
