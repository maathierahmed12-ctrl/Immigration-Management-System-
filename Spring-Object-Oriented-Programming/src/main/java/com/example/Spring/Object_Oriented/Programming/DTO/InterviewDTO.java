package com.example.Spring.Object_Oriented.Programming.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InterviewDTO {


        private Long applicantId;
        private Long officerId;
        private String date;
        private String status;

        public InterviewDTO() {
        }

}

