package com.example.Spring.Object_Oriented.Programming.Controllers;

import com.example.Spring.Object_Oriented.Programming.Entity.Applicant;
import com.example.Spring.Object_Oriented.Programming.Entity.VisaApplication;
import com.example.Spring.Object_Oriented.Programming.Services.VisaApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visa")
public class VisaApplicationController {

    private VisaApplicationController VisaApplicationController;

    public VisaApplicationController(VisaApplication VisaApplication) {
    }

    @PostMapping("/submit/{applicantId}")
    public VisaApplicationController submitVisa(@PathVariable Long applicantId,
                                      @RequestParam String type) {

        return VisaApplicationController.submitVisa(applicantId, type);
    }

    @PutMapping("/assign/{visaId}/{officerId}")
    public VisaApplicationController assignOfficer(@PathVariable Long visaId,
                                         @PathVariable Long officerId) {

        return VisaApplicationController.assignOfficer(visaId, officerId);
    }

    @PutMapping("/process/{visaId}")
    public VisaApplicationController processVisa(@PathVariable Long visaId,
                                       @RequestParam String status,
                                       @RequestParam String notes) {

        return VisaApplicationController.processVisa(visaId, status, notes);
    }

    @GetMapping("/status/{status}")
    public List<VisaApplication> findByStatus(@PathVariable String status) {

        return VisaApplicationController.findByStatus(status);
    }

    @GetMapping("/applicant/{applicantId}")
    public List<VisaApplication> findByApplicant(@PathVariable Long applicantId) {

        return VisaApplicationController.findByApplicant(applicantId);
    }
}