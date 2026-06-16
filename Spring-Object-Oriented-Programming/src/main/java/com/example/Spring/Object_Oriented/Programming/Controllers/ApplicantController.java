package com.example.Spring.Object_Oriented.Programming.Controllers;
import com.example.Spring.Object_Oriented.Programming.Entity.Applicant;
import com.example.Spring.Object_Oriented.Programming.Entity.AsylumSeeker;
import com.example.Spring.Object_Oriented.Programming.Repository.ApplicationRepository;
import com.example.Spring.Object_Oriented.Programming.Services.ImplementApplicant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private  ApplicationRepository applicantRepository;
    private  ImplementApplicant ImplementApplicant;

    public ApplicantController(ApplicationRepository applicantRepository,
                               ImplementApplicant ImplementApplicant) {
        this.applicantRepository = applicantRepository;
        this.ImplementApplicant = ImplementApplicant;
    }

    @PostMapping
    public Applicant registerApplicant(@RequestBody Applicant applicant) {
        return ImplementApplicant.saveApplicant(applicant);
    }

    @PostMapping("/asylum")
    public AsylumSeeker registerAsylum(@RequestBody AsylumSeeker seeker) {
        return ImplementApplicant.saveApplicant(seeker);
    }

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @GetMapping("/search")
    public List<Applicant> findByNationality(@RequestParam String nationality) {
        return applicantRepository.findByNationality(nationality);
    }

    @PutMapping("/{id}/flag")
    public String flagCriminalRecord(@PathVariable Long id) {
        ImplementApplicant.flagCriminalRecord(id);
        return "Applicant flagged as criminal and interviews cancelled";
    }
}