package com.example.Spring.Object_Oriented.Programming.Controllers;

import com.example.Spring.Object_Oriented.Programming.Entity.BorderControlOfficer;
import com.example.Spring.Object_Oriented.Programming.Entity.ImmigrationOfficer;
import com.example.Spring.Object_Oriented.Programming.Entity.VisaApplication;
import com.example.Spring.Object_Oriented.Programming.Repository.OfficerRepository;
import com.example.Spring.Object_Oriented.Programming.Services.OfficerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/officers")
public class OfficerController {

    private final OfficerRepository officerRepository;
    private final OfficerService officerService;

    public OfficerController(OfficerRepository officerRepository,
                             OfficerService officerService) {
        this.officerRepository = officerRepository;
        this.officerService = officerService;
    }

    @PostMapping
    public ImmigrationOfficer hireOfficer(@RequestBody ImmigrationOfficer officer) {
        return officerRepository.save(officer);
    }

    @PostMapping("/border")
    public BorderControlOfficer hireBorderOfficer(@RequestBody BorderControlOfficer officer) {
        return officerRepository.save(officer);
    }

    @GetMapping("/{id}")
    public ImmigrationOfficer getOfficer(@PathVariable Long id) {
        return officerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Officer not found"));
    }

    @PutMapping("/{id}/promote")
    public ImmigrationOfficer promoteOfficer(@PathVariable Long id,
                                             @RequestParam String rank,
                                             @RequestParam int clearance) {

        return officerService.promoteOfficer(id, rank, clearance);
    }

    @PutMapping("/{id}/transfer/{centerId}")
    public ImmigrationOfficer transferOfficer(@PathVariable Long id,
                                              @PathVariable Long centerId) {

        return officerService.transferOfficer(id, centerId);
    }
    @GetMapping
    public VisaApplication assignOfficer(Long visaId, Long officerId) {

        VisaApplication visa = VisaApplication.findById(visaId)
                .orElseThrow(() -> new RuntimeException("Visa not found"));

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        visa.setHandlingOfficer(officer);

        return VisaApplication.save(visa);
    }
}

