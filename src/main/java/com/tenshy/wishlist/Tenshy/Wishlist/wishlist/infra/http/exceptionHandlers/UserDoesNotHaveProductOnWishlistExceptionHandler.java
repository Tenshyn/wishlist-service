package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.http.exceptionHandlers;

import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.TooManyProductsInWishlistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserDoesNotHaveProductOnWishlistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserDoesNotHaveProductOnWishlistExceptionHandler extends RuntimeException {

    @ExceptionHandler(value = UserDoesNotHaveProductOnWishlistException.class)
    public ResponseEntity<Object> handle(UserDoesNotHaveProductOnWishlistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
