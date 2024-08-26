package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_DATA")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", columnDefinition = "INT")
    private long id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(50)", unique = true)
    private String name;

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR(225)")
    private String password;

    public UserData(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
