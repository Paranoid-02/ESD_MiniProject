package com.example.miniproject.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "organization_hr")
public class OrganizationHR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    private String hrName;
    private String hrEmail;
    private String hrPhone;

}