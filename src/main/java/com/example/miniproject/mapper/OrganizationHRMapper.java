package com.example.miniproject.mapper;

import com.example.miniproject.Model.Organization;
import com.example.miniproject.Model.OrganizationHR;
import com.example.miniproject.dto.OrganizationHRDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationHRMapper {
    OrganizationHRDTO toDTO(OrganizationHR hr);

    OrganizationHR toEntity(OrganizationHRDTO hrDTO);
}