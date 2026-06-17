package com.example.Spring.Object_Oriented.Programming.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class ImmigrationOfficer extends Person {

     @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Badge number is required")
        @Size(min = 3, max = 20, message = "Badge number must be between 3 and 20 characters")
        private String badgeNumber;

        @NotBlank(message = "Rank is required")
        @Size(min = 1, max = 15, message = "Rank must be between 1 and 15 characters")
        private String rank;

        @NotBlank(message = "Clearance level is required")
        @Pattern(regexp = "[1-5]", message = "Clearance level must be between 1 and 5")
        private String clearanceLevel;

        @NotNull(message = "Active status is required")
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