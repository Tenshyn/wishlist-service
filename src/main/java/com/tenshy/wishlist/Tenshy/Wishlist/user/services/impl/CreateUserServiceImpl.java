package com.tenshy.wishlist.Tenshy.Wishlist.user.services.impl;

import com.tenshy.wishlist.Tenshy.Wishlist.user.dtos.UserDTO;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities.User;
import com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.repositories.UserRepository;
import com.tenshy.wishlist.Tenshy.Wishlist.user.mappers.UserMapper;
import com.tenshy.wishlist.Tenshy.Wishlist.user.services.ICreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserServiceImpl implements ICreateUserService {

    private final UserRepository userRepository;

    @Autowired
    public CreateUserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(final UserDTO userDTO) {
        final User entityToBeSaved = UserMapper.mapper(userDTO);
        return userRepository.save(entityToBeSaved);
    }
}
