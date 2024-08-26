package com.example.demo.controller;

import com.example.demo.handler.UserHandler;
import com.example.demo.handler.impl.HandlerFactory;
import com.example.demo.model.dto.UserDataDto;
import com.example.demo.model.entity.UserData;
import com.example.demo.model.rq.CreateUserRq;
import com.example.demo.model.rq.UserLoginRq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final HandlerFactory handlerFactory;

    @GetMapping("/{input}")
    public ResponseEntity<String> test(@PathVariable String input) {
        log.info("input: {}", input);
        return ResponseEntity.ok(input);
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDataDto> createUser(@RequestBody CreateUserRq rq) {
        UserHandler userHandler = handlerFactory.getUserHandler();
        return ResponseEntity.ok(userHandler
                .createUser(new UserData(rq.getUsername(), rq.getPassword()))
                .getUserData());
    }

    @PostMapping("/login")
    public ResponseEntity<UserDataDto> login(@RequestBody UserLoginRq rq) {
        UserHandler userHandler = handlerFactory.getUserHandler();
        return ResponseEntity.ok(userHandler
                .login(rq.getUsername(), rq.getPassword())
                .getUserData());
    }

    // 取得資料 ( 一般這種方法需要有認證 ex. Jwt )
    @GetMapping("/user/{name}")
    public ResponseEntity<UserDataDto> getUserData(@PathVariable String name) {
        UserHandler userHandler = handlerFactory.getUserHandler();
        return ResponseEntity.ok(userHandler.getUserDateByName(name));
    }

}
