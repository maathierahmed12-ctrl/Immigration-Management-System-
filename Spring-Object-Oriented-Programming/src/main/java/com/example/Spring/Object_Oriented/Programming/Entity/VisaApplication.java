package com.example.Spring.Object_Oriented.Programming.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Entity
public class VisaApplication {


        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 20, message = "First name must be 2-20 characters")
        private String firstName;

        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 20, message = "Last name must be 2-20 characters")
        private String lastName;

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        private String email;

        @NotBlank(message = "Phone number is required")
        @Size(min = 8, max = 15, message = "Phone number must be 8-15 digits")
        private String phoneNumber;

        @Min(value = 18, message = "Age must be at least 18")
        private int age;

        public void findByApplicantId(Long applicantId) {
        }
}

