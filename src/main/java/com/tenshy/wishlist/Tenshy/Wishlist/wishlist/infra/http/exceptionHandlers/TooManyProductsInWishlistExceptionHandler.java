package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.http.exceptionHandlers;

import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.TooManyProductsInWishlistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TooManyProductsInWishlistExceptionHandler extends RuntimeException {

    @ExceptionHandler(value = TooManyProductsInWishlistException.class)
    public ResponseEntity<Object> handle(TooManyProductsInWishlistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
