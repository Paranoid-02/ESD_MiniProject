package com.example.miniproject.dto;

@Data
public class UserCreateDTO {
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}