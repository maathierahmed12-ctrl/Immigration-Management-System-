package com.example.Spring.Object_Oriented.Programming.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Interview {

        public static final @NotBlank(message = "First name is required")
        @Size(min = 2, max = 20, message = "First name must be 2-20 characters") String SCHEDULED = "";
        public static final Object CANCELLED = null;
        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 20, message = "First name must be 2-20 characters")
        private String firstName;

        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 20, message = "Last name must be 2-20 characters")
        private String lastName;

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        private String email;

        @NotBlank(message = "Rank is required")
        @Size(min = 1, max = 10, message = "Rank must be 1-10 characters")
        private String rank;

        @Min(value = 1, message = "Clearance level must be at least 1")
        @Max(value = 5, message = "Clearance level must not exceed 5")
        private int clearanceLevel;


        public void getEmail(Object cancelled) {
        }
}