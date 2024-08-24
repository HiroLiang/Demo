package com.example.demo.handler.impl;

import com.example.demo.handler.UserHandler;
import com.example.demo.model.dto.UserDataDto;
import com.example.demo.model.entity.UserData;
import com.example.demo.service.UserService;
import com.example.demo.util.EncryptUtil;

public class UserHandlerImpl implements UserHandler {

    private final UserService userService;

    private UserData userData;

    private UserHandlerImpl(UserService userService) {
        this.userService = userService;
    }

    protected static UserHandler getInstance(UserService userService) {
        return new UserHandlerImpl(userService);
    }

    @Override
    public UserHandler createUser(UserData userData) {
        userData.setPassword(EncryptUtil.passwordEncode(userData.getPassword()));
        this.userData = userService.createUser(userData);
        return this;
    }

    @Override
    public UserHandler login(String username, String password) {
        UserData user = userService.getUserData(username);
        if(!EncryptUtil.passwordMatches(password, user.getPassword()))
            throw new RuntimeException("Password does not match");
        this.userData = user;
        return this;
    }

    @Override
    public UserDataDto getUserData() {
        if(userData == null)
            throw new RuntimeException("User data not set");
        return new UserDataDto(this.userData);
    }
}
