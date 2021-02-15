package com.exam.shoppinglist.service.impl;

import com.exam.shoppinglist.model.entity.User;
import com.exam.shoppinglist.model.service.UserServiceModel;
import com.exam.shoppinglist.repository.UserRepository;
import com.exam.shoppinglist.service.UserService;
import com.exam.shoppinglist.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        try {
            this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return this.userRepository.findByUsernameAndPassword(username, password)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
