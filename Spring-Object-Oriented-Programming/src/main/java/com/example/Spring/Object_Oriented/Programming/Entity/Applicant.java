package com.example.Spring.Object_Oriented.Programming.Entity;

import com.example.Spring.Object_Oriented.Programming.DTO.VisaApplicantDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Applicant extends Person {
    @Getter
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Passport number is required")
    @Size(min = 6, max = 15, message = "Passport number must be between 6 and 15 characters")
    private String passportNumber;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    @Email(message = "Invalid email format")
    private String email;

    private String phoneNumber;

    private String gender;

    private boolean criminalRecord;

    public static Applicant saveApplicant(VisaApplicantDTO dto) {
        return null;
    }


}