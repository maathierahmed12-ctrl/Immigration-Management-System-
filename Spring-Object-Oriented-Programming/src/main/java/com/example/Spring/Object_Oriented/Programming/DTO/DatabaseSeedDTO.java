package com.example.Spring.Object_Oriented.Programming.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DatabaseSeedDTO {

        private String centerName;
        private String country;
        private String centerType;
        private int capacity;

        public DatabaseSeedDTO() {
        }

}

