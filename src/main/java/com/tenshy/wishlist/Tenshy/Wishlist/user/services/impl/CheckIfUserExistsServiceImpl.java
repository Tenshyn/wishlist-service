package com.tenshy.wishlist.Tenshy.Wishlist.user.services.impl;

import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.repositories.UserRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.user.services.ICheckIfUserExistsService;
import com.tenshy.wishlist.Tenshy.Wishlist.wishlist.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckIfUserExistsServiceImpl implements ICheckIfUserExistsService {

    private final UserRepository userRepository;

    @Autowired
    public CheckIfUserExistsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(final UUID userId) {
        final boolean userDoesNotExists = !userRepository.existsById(userId);
        if(userDoesNotExists)
            throw new UserDoesNotExistException("Could not find user with specified Id");
    }
}
