package com.tenshy.wishlist.Tenshy.Wishlist.user.services.impl;

import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.repositories.UserRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.user.services.IRetrieveAllUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetrieveAllUsersServiceImpl implements IRetrieveAllUsersService {

    private final UserRepository userRepository;

    @Autowired
    public RetrieveAllUsersServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> execute() {
        final List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
