package com.example.miniproject.mapper;

import com.example.miniproject.dto.OrganizationHRDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationHRMapper {
    OrganizationHRDTO toDTO(OrganizationHR organizationHR);
    OrganizationHR toEntity(OrganizationHRDTO organizationHRDTO);
}