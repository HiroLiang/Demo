package com.example.demo.model.dto;

import com.example.demo.model.entity.UserData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDto {

    private String username;

    public UserDataDto(UserData userData) {
        this.username = userData.getName();
    }

}
