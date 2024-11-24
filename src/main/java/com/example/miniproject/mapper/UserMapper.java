package com.example.miniproject.mapper;

import com.example.miniproject.Model.User;
import com.example.miniproject.dto.UserDTO;
import com.example.miniproject.dto.UserCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO userDTO);

    @Mapping(target = "id", ignore = true)
    User createDtoToEntity(UserCreateDTO createDTO);
}