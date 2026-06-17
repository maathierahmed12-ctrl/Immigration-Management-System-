package com.example.Spring.Object_Oriented.Programming.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VisaApplicantDTO {


    private String firstName;
    private String lastName;
    private String passportNumber;
    private String nationality;
    private String phoneNumber;

    public VisaApplicantDTO() {
    }

}

