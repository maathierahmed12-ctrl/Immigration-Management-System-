package com.example.Spring.Object_Oriented.Programming.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class ImmigrationOfficer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String badgeNumber;
    private String rank;
    private String clearanceLevel;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private ImmigrationCenter center;

    @OneToMany(mappedBy = "officer")
    private List<Interview> interviews;

    public ImmigrationOfficer(Long id, String badgeNumber, String rank,
                              String clearanceLevel, boolean active,
                              ImmigrationCenter center, List<Interview> interviews) {
        this.id = id;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.clearanceLevel = clearanceLevel;
        this.active = active;
        this.center = center;
        this.interviews = interviews;
    }

    public ImmigrationOfficer() {
    }

    @Override
    public String toString() {
        return "ImmigrationOfficer{" +
                "id=" + id +
                ", badgeNumber='" + badgeNumber + "..."+
                ", rank='" + rank + "..." +
                ", clearanceLevel='" + clearanceLevel + "..." +
                ", active=" + active +
                '}';
    }
}

