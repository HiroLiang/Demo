package com.example.demo.handler;

import com.example.demo.model.dto.UserDataDto;
import com.example.demo.model.entity.UserData;

public interface UserHandler {

    UserHandler createUser(UserData userData);

    UserHandler login(String username, String password);

    UserDataDto getUserData();

    UserDataDto getUserDateByName(String username);
}
