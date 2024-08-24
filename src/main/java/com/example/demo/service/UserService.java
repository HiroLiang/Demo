package com.example.demo.service;

import com.example.demo.model.entity.UserData;
import com.example.demo.repository.UserDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDataRepository userDataRepository;

    @Transactional
    public UserData createUser(final UserData userData) {
        userDataRepository.findByNameWithLock(userData.getName()).ifPresent(user -> {
           throw new RuntimeException("User already exists");
        });
        return userDataRepository.save(userData);
    }

    @Transactional
    public UserData getUserData(final String username) {
        return userDataRepository.findByNameWithLock(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
