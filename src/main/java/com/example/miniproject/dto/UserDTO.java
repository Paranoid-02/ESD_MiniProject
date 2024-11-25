package com.example.miniproject.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Builder
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
}