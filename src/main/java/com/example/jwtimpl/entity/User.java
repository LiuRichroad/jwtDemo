package com.example.jwtimpl.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Integer id;
    private String name;
    private String password;
}
