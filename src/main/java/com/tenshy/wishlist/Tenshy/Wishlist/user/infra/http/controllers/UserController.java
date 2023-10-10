package com.tenshy.wishlist.Tenshy.Wishlist.user.infra.http.controllers;

import com.tenshy.wishlist.Tenshy.Wishlist.user.dtos.UserDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;
import com.tenshy.wishlist.Tenshy.Wishlist.user.services.ICreateUserService;
import com.tenshy.wishlist.Tenshy.Wishlist.user.services.IRetrieveAllUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
DISCLAIMER: THIS CONTROLLER IS MEANT TO BE USED ONLY FOR TESTING
HENCE NO VALIDATIONS OR TREATED EXCEPTIONS
 */

@RestController
@RequestMapping("users")
public class UserController {

    private final ICreateUserService createUserService;
    private final IRetrieveAllUsersService retrieveAllUsersService;

    @Autowired
    public UserController(final ICreateUserService createUserService,
                          final IRetrieveAllUsersService retrieveAllUsersService) {
        this.createUserService = createUserService;
        this.retrieveAllUsersService = retrieveAllUsersService;
    }

    @RequestMapping
    public ResponseEntity<List<User>> show() {
        final List<User> users = this.retrieveAllUsersService.execute();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) {
        final User user = this.createUserService.execute(userDTO);
        return ResponseEntity.status(201).body(user);
    }


}
