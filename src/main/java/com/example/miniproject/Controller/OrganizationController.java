package com.example.miniproject.Controller;

import com.example.miniproject.Service.OrganizationService;
import com.example.miniproject.dto.OrganizationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        List<OrganizationDTO> organizations = organizationService.getAllOrganizations();
        return ResponseEntity.ok(organizations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable Long id) {
        OrganizationDTO organization = organizationService.getOrganizationById(id);
        if (organization != null) {
            return ResponseEntity.ok(organization);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO newOrganization = organizationService.createOrganization(organizationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrganization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDTO> updateOrganization(@PathVariable Long id, @RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO updatedOrganization = organizationService.updateOrganization(id, organizationDTO);
        if (updatedOrganization != null) {
            return ResponseEntity.ok(updatedOrganization);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}
