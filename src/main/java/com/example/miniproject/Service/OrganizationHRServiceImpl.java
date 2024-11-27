package com.example.miniproject.Service;

import com.example.miniproject.dto.OrganizationHRDTO;
import com.example.miniproject.mapper.OrganizationHRMapper;
import com.example.miniproject.Model.Organization;
import com.example.miniproject.Model.OrganizationHR;
import com.example.miniproject.Repository.OrganizationHRRepository;
import com.example.miniproject.Repository.OrganizationRepository;
import com.example.miniproject.Service.OrganizationHRService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrganizationHRServiceImpl implements OrganizationHRService {
    private final OrganizationHRRepository hrRepository;
    private final OrganizationRepository organizationRepository;
    private final OrganizationHRMapper hrMapper;

    public OrganizationHRServiceImpl(OrganizationHRRepository hrRepository, OrganizationRepository organizationRepository, OrganizationHRMapper hrMapper) {
        this.hrRepository = hrRepository;
        this.organizationRepository = organizationRepository;
        this.hrMapper = hrMapper;
    }

    @Override
    public List<OrganizationHRDTO> getHRContactsByOrganization(Long organizationId) {
        return hrRepository.findAll().stream()
                .filter(hr -> hr.getOrganization().getId().equals(organizationId))
                .map(hrMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationHRDTO getHRContactById(Long id) {
        Optional<OrganizationHR> hr = hrRepository.findById(id);
        return hr.map(hrMapper::toDTO).orElse(null);
    }

    @Override
    public OrganizationHRDTO createHRContact(Long organizationId, OrganizationHRDTO hrDTO) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);
        if (organization.isPresent()) {
            OrganizationHR hr = hrMapper.toEntity(hrDTO);
            hr.setOrganization(organization.get());
            hr = hrRepository.save(hr);
            return hrMapper.toDTO(hr);
        }
        return null;
    }

    @Override
    public OrganizationHRDTO updateHRContact(Long id, OrganizationHRDTO hrDTO) {
        Optional<OrganizationHR> existingHR = hrRepository.findById(id);
        if (existingHR.isPresent()) {
            OrganizationHR hr = existingHR.get();
            hr.setHrName(hrDTO.getHrName());
            hr.setHrEmail(hrDTO.getHrEmail());
            hr.setHrPhone(hrDTO.getHrPhone());
            hr = hrRepository.save(hr);
            return hrMapper.toDTO(hr);
        }
        return null;
    }

    @Override
    public void deleteHRContact(Long id) {
        hrRepository.deleteById(id);
    }
}