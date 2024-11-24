package com.example.miniproject.Controller;


import com.example.miniproject.Service.OrganizationHRService;
import com.example.miniproject.dto.OrganizationHRDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{organizationId}/hr")
public class OrganizationHRController {
    private final OrganizationHRService hrService;

    public OrganizationHRController(OrganizationHRService hrService) {
        this.hrService = hrService;
    }

    @GetMapping
    public ResponseEntity<List<OrganizationHRDTO>> getHRContactsByOrganization(@PathVariable Long organizationId) {
        List<OrganizationHRDTO> hrContacts = hrService.getHRContactsByOrganization(organizationId);
        return ResponseEntity.ok(hrContacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationHRDTO> getHRContactById(@PathVariable Long organizationId, @PathVariable Long id) {
        OrganizationHRDTO hrContact = hrService.getHRContactById(id);
        if (hrContact != null) {
            return ResponseEntity.ok(hrContact);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<OrganizationHRDTO> createHRContact(
            @PathVariable Long organizationId, @RequestBody OrganizationHRDTO hrDTO) {
        OrganizationHRDTO newHRContact = hrService.createHRContact(organizationId, hrDTO);
        if (newHRContact != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newHRContact);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationHRDTO> updateHRContact(
            @PathVariable Long organizationId, @PathVariable Long id, @RequestBody OrganizationHRDTO hrDTO) {
        OrganizationHRDTO updatedHRContact = hrService.updateHRContact(id, hrDTO);
        if (updatedHRContact != null) {
            return ResponseEntity.ok(updatedHRContact);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHRContact(@PathVariable Long organizationId, @PathVariable Long id) {
        hrService.deleteHRContact(id);
        return ResponseEntity.noContent().build();
    }
}
