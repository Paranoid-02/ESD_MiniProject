package com.example.miniproject.mapper;

import com.example.miniproject.Model.User;
import com.example.miniproject.dto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupToUserMapper {

    public User toEntity(SignupRequest request){
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .username(request.getUsername())
                .build();
    }
}
