package com.example.miniproject.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrganizationDTO {
    private Long id;
    private String name;
    private String address;
    private List<OrganizationHRDTO> hrContacts;

}