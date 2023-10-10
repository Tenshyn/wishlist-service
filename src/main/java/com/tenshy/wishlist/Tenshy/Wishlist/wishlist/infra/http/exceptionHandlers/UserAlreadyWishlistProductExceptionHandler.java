package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.http.exceptionHandlers;

import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserAlreadyWishlistProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAlreadyWishlistProductExceptionHandler extends RuntimeException {

    @ExceptionHandler(value = UserAlreadyWishlistProduct.class)
    public ResponseEntity<Object> handle(UserAlreadyWishlistProduct exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
