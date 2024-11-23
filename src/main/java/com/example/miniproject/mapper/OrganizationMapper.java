package com.example.miniproject.mapper;

import com.example.miniproject.Model.Organization;
import com.example.miniproject.dto.OrganizationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrganizationHRMapper.class})
public interface OrganizationMapper {
    @Mapping(source = "hrContacts", target = "hrContacts")
    OrganizationDTO toDTO(Organization organization);

    @Mapping(target = "hrContacts", ignore = true)
    Organization toEntity(OrganizationDTO organizationDTO);
}