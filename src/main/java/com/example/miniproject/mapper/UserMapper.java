package com.example.miniproject.mapper;

import com.example.miniproject.Model.User;
import com.example.miniproject.dto.UserDTO;
import com.example.miniproject.dto.UserCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public class UserMapper {
    public UserDTO toDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

//    @Mapping(target = "password", ignore = true)
//    User toEntity(UserDTO userDTO);
//
//    @Mapping(target = "id", ignore = true)
//    User createDtoToEntity(UserCreateDTO createDTO);
}