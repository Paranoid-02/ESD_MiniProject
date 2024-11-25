package com.example.miniproject.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@Data  // Generates getters, setters, equals, hashCode, toString methods automatically
@NoArgsConstructor  // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with arguments for all fields
@Builder // Generates the builder pattern for the class
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;

    @Column(unique = true)
    private String email;

//    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<String> roles;
}