package com.example.Spring.Object_Oriented.Programming.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public class Person {

        private Long id;

        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 20, message = "First name must be 2-20 characters")
        private String firstName;

        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 20, message = "Last name must be 2-20 characters")
        private String lastName;

        @NotBlank(message = "Gender is required")
        @Pattern(regexp = "Male|Female", message = "Gender must be Male or Female")
        private String gender;

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^[0-9]{8,15}$", message = "Phone number must be 8-15 digits")
        private String phoneNumber;

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        private String email;

        public Person() {
        }

        public Person(String firstName, String lastName, String gender,
                      String phoneNumber, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + "..." +
                    ", lastName='" + lastName + "///" +
                    ", gender='" + gender + "///" +
                    ", phoneNumber='" + phoneNumber + "..." +
                    ", email='" + email + "..." +
                    '}';
        }
    }