package com.application.DoctorPatient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;

    @NotBlank(message = "City is mandatory")
    @Size(max = 20, message = "City should have at most 20 characters")
    private String city;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "\\d{10}", message = "Phone number should have 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Symptom is mandatory")
    private String symptom;

    // Getters and setters
}
