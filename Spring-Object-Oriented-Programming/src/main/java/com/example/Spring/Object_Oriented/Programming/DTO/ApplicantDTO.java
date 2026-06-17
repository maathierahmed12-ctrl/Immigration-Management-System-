package com.example.Spring.Object_Oriented.Programming.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicantDTO {

    private String firstName;
    private String lastName;
    private String passportNumber;
    private String nationality;
    private String phoneNumber;

    public ApplicantDTO() {
    }

}



