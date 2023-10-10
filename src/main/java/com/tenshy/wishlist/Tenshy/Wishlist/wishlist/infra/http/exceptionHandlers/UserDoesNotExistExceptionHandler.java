package com.tenshy.wishlist.Tenshy.Wishlist.wishlist.infra.http.exceptionHandlers;

import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.TooManyProductsInWishlistException;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserDoesNotExistExceptionHandler extends RuntimeException {

    @ExceptionHandler(value = UserDoesNotExistException.class)
    public ResponseEntity<Object> handle(UserDoesNotExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
