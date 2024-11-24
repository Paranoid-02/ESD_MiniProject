package com.example.miniproject.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationHRDTO {
    private Long id;
    private String hrName;
    private String hrEmail;
    private String hrPhone;
    private Long organizationId;
}