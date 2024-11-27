package com.example.miniproject.Service;

import com.example.miniproject.dto.OrganizationHRDTO;
import java.util.List;

public interface OrganizationHRService {
    List<OrganizationHRDTO> getHRContactsByOrganization(Long organizationId);
    OrganizationHRDTO getHRContactById(Long id);
    OrganizationHRDTO createHRContact(Long organizationId, OrganizationHRDTO hrDTO);
    OrganizationHRDTO updateHRContact(Long id, OrganizationHRDTO hrDTO);
    void deleteHRContact(Long id);
}
