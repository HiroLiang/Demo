package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EncryptUtil {

    private static PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public void setPasswordEncoder(@Qualifier(value = "passwordEncoder") PasswordEncoder passwordEncoder) {
        EncryptUtil.encoder = passwordEncoder;
    }

    public static String passwordEncode(String password) {
        return encoder.encode(password);
    }

    public static boolean passwordMatches(String password, String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }

}
