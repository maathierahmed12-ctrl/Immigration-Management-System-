package com.example.Spring.Object_Oriented.Programming.Entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BorderControlOfficer extends ImmigrationOfficer {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Assigned checkpoint is required")
    private String assignedCheckpoint;

    private boolean k9UnitAssigned;


}