package com.example.Spring.Object_Oriented.Programming.Controllers;
import com.example.Spring.Object_Oriented.Programming.DTO.ApplicantDTO;
import com.example.Spring.Object_Oriented.Programming.Entity.Applicant;
import com.example.Spring.Object_Oriented.Programming.Entity.AsylumSeeker;
import com.example.Spring.Object_Oriented.Programming.Repository.ApplicantRepository;
import com.example.Spring.Object_Oriented.Programming.Services.ImplementApplicant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private ApplicantRepository applicantRepository;
    private  ImplementApplicant ImplementApplicant;

    public ApplicantController(ApplicantRepository applicantRepository,
                               ImplementApplicant ImplementApplicant) {
        this.applicantRepository = applicantRepository;
        this.ImplementApplicant = ImplementApplicant;
    }

    @PostMapping
    public Applicant registerApplicant(@RequestBody AsylumSeeker applicant) {
        return ImplementApplicant.saveApplicant(applicant);
    }

    @PostMapping("/asylum")
    public Applicant registerAsylum(@RequestBody AsylumSeeker seeker) {
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

        private ImplementApplicant applicantService;

        public ApplicantController(ImplementApplicant applicantService) {
            this.applicantService = applicantService;
        }

        @PostMapping("/create")
        public ApplicantDTO createApplicant(@RequestBody ApplicantDTO dto) {
            return applicantService.saveApplicant(dto);
        }
    }
