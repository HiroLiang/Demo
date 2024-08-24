package com.example.demo.handler.impl;

import com.example.demo.handler.UserHandler;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HandlerFactory {

    private final UserService userService;

    public UserHandler getUserHandler() {
        return UserHandlerImpl.getInstance(userService);
    }

}
