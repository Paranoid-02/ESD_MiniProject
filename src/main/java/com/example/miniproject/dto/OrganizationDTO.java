package com.example.miniproject.dto;

import lombok.Data;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrganizationDTO {
    private Long id;
    private String name;
    private String address;
    private LocalDateTime createdAt;
    private List<OrganizationHRDTO> hrContacts;
}