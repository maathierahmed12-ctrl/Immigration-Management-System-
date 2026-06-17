package com.example.Spring.Object_Oriented.Programming.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class ImmigrationCenter {


        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
        private String firstName;

        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
        private String lastName;

        @NotBlank(message = "Rank is required")
        @Size(min = 2, max = 15, message = "Rank must be between 2 and 15 characters")
        private String rank;

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        private String email;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }