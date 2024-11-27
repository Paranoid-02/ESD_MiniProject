package com.example.miniproject.Service;

import com.example.miniproject.dto.OrganizationDTO;
import com.example.miniproject.mapper.OrganizationMapper;
import com.example.miniproject.Model.Organization;
import com.example.miniproject.Repository.OrganizationRepository;
import com.example.miniproject.Service.OrganizationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        return organizationRepository.findAll().stream()
                .map(organizationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationDTO getOrganizationById(Long id) {
        Optional<Organization> organization = organizationRepository.findById(id);
        return organization.map(organizationMapper::toDTO).orElse(null);
    }

    @Override
    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
        Organization organization = organizationMapper.toEntity(organizationDTO);
        organization = organizationRepository.save(organization);
        return organizationMapper.toDTO(organization);
    }

    @Override
    public OrganizationDTO updateOrganization(Long id, OrganizationDTO organizationDTO) {
        Optional<Organization> existingOrganization = organizationRepository.findById(id);
        if (existingOrganization.isPresent()) {
            Organization organization = existingOrganization.get();
            organization.setName(organizationDTO.getName());
            organization.setAddress(organizationDTO.getAddress());
            organization = organizationRepository.save(organization);
            return organizationMapper.toDTO(organization);
        }
        return null;
    }

    @Override
    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}