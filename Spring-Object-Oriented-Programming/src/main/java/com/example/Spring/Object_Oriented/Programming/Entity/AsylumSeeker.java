package com.example.Spring.Object_Oriented.Programming.Entity;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class AsylumSeeker extends Person{

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Country of origin is required")
    private String countryOfOrigin;

    @Size(min = 3, max = 100, message = "Sponsor organization must be between 3 and 100 characters")
    private String sponsorOrganization;


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

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getSponsorOrganization() {
        return sponsorOrganization;
    }

    public void setSponsorOrganization(String sponsorOrganization) {
        this.sponsorOrganization = sponsorOrganization;
    }
}