package com.example.Spring.Object_Oriented.Programming.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private ImmigrationOfficer officer;

    private String interviewDate;

    private String status;

    private String purpose;

    public Interview(Long id, Applicant applicant,
                     ImmigrationOfficer officer,
                     String interviewDate,
                     String status,
                     String purpose) {
        this.id = id;
        this.applicant = applicant;
        this.officer = officer;
        this.interviewDate = interviewDate;
        this.status = status;
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", interviewDate='" + interviewDate + "..." +
                ", status='" + status + "..." +
                ", purpose='" + purpose + "..." +
                '}';
    }

}