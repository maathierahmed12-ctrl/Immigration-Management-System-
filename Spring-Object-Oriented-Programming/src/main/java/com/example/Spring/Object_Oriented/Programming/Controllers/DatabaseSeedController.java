package com.example.Spring.Object_Oriented.Programming.Controllers;
import com.example.Spring.Object_Oriented.Programming.Entity.*;
import com.example.Spring.Object_Oriented.Programming.Repository.CenterRepository;
import com.example.Spring.Object_Oriented.Programming.Repository.OfficerRepository;
import com.example.Spring.Object_Oriented.Programming.Services.ImplementApplicant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DatabaseSeedController {

    private final CenterRepository centerRepository;
    private final OfficerRepository officerRepository;
    private ImplementApplicant ImplementApplicant;

    public DatabaseSeedController(CenterRepository centerRepository,
                                  OfficerRepository officerRepository,
                                  ImplementApplicant ImplementApplicant) {

        this.centerRepository = centerRepository;
        this.officerRepository = officerRepository;
        this.ImplementApplicant = ImplementApplicant;
    }

    @PostMapping("/seed")
    public String seedDatabase() {

        ImmigrationCenter center1 = new ImmigrationCenter();
        center1.setName("Muscat Immigration Center");

        ImmigrationCenter center2 = new ImmigrationCenter();
        center2.setName("Salalah Immigration Center");

        centerRepository.save(center1);
        centerRepository.save(center2);

        ImmigrationOfficer officer1 = new ImmigrationOfficer();
        officer1.setFirstName("Ahmed");
        officer1.setLastName("Ali");

        BorderControlOfficer officer2 = new BorderControlOfficer();
        officer2.setFirstName("Mohammed");
        officer2.setLastName("Salim");

        ImmigrationOfficer officer3 = new ImmigrationOfficer();
        officer3.setFirstName("Khalid");
        officer3.setLastName("Saeed");

        officerRepository.save(officer1);
        officerRepository.save(officer2);
        officerRepository.save(officer3);

        Applicant applicant1 = new Applicant();
        applicant1.setFirstName("John");
        applicant1.setLastName("Smith");

        AsylumSeeker applicant2 = new AsylumSeeker();
        applicant2.setFirstName("Omar");
        applicant2.setLastName("Hassan");

        Applicant applicant3 = new Applicant();
        applicant3.setFirstName("Ali");
        applicant3.setLastName("Nasser");
        applicant3.setCriminalRecord(true);

        Applicant applicant4 = new Applicant();
        applicant4.setFirstName("Sara");
        applicant4.setLastName("Ahmed");

        Applicant.save(applicant1);
        Applicant.save(applicant2);
        Applicant.save(applicant3);
        Applicant.save(applicant4);

        return "Database seeded successfully!";
    }
}
