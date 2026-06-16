package com.example.Spring.Object_Oriented.Programming.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ImmigrationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;

    @OneToMany(mappedBy = "center")
    private List<ImmigrationOfficer> officers;

    public ImmigrationCenter(Long id, String name, String locationCountry,
                             String type, int dailyCapacity) {
        this.id = id;
        this.name = name;
        this.locationCountry = locationCountry;
        this.type = type;
        this.dailyCapacity = dailyCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDailyCapacity() {
        return dailyCapacity;
    }

    public void setDailyCapacity(int dailyCapacity) {
        this.dailyCapacity = dailyCapacity;
    }

    public List<ImmigrationOfficer> getOfficers() {
        return officers;
    }

    public void setOfficers(List<ImmigrationOfficer> officers) {
        this.officers = officers;
    }

    @Override
    public String toString() {
        return "ImmigrationCenter{" +
                "id=" + id +
                ", name='" + name + "..." +
                ", locationCountry='" + locationCountry + "..." +
                ", type='" + type + "...." +
                ", dailyCapacity=" + dailyCapacity +
                '}';
    }
}