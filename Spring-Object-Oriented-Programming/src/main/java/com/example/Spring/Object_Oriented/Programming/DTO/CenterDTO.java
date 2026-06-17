package com.example.Spring.Object_Oriented.Programming.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CenterDTO {


    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;

    public CenterDTO() {
    }

}

