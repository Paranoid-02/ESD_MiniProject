package com.example.miniproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "UserName is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
}