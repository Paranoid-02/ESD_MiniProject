package com.example.miniproject.Service;

import com.example.miniproject.dto.OrganizationDTO;
import java.util.List;

public interface OrganizationService {
    List<OrganizationDTO> getAllOrganizations();
    OrganizationDTO getOrganizationById(Long id);
    OrganizationDTO createOrganization(OrganizationDTO organizationDTO);
    OrganizationDTO updateOrganization(Long id, OrganizationDTO organizationDTO);
    void deleteOrganization(Long id);
}