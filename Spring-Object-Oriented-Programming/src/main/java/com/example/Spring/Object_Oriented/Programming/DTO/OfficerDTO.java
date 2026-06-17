package com.example.Spring.Object_Oriented.Programming.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OfficerDTO {

        private String firstName;
        private String lastName;
        private String rank;
        private String department;
        private String email;

        public OfficerDTO() {
        }

}

