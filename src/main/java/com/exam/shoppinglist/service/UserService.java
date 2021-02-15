package com.exam.shoppinglist.service;

import com.exam.shoppinglist.model.service.UserServiceModel;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
