package com.example.Spring.Object_Oriented.Programming.Controllers;

import com.example.Spring.Object_Oriented.Programming.Entity.VisaApplication;
import com.example.Spring.Object_Oriented.Programming.Repository.VisaApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VisaApplicationService {

    private final VisaApplicationRepository visaApplicationRepository;

    public VisaApplicationService(VisaApplicationRepository visaApplicationRepository) {
        this.visaApplicationRepository = visaApplicationRepository;
    }

    public VisaApplication submitVisa(Long applicantId, String type) {

        VisaApplication visa = new VisaApplication();
        visa.setVisaType(type);
        visa.setStatus("PENDING");
        visa.setApplicant(applicantId);

        return visaApplicationRepository.save(visa);
    }

    public VisaApplication assignOfficer(Long visaId, Long officerId) {

        VisaApplication visa = visaApplicationRepository.findById(visaId)
                .orElseThrow(() -> new RuntimeException("Visa not found"));

        visa.setHandlingOfficer(officerId);

        return visaApplicationRepository.save(visa);
    }

    public VisaApplication processVisa(Long visaId, String status, String notes) {

        VisaApplication visa = visaApplicationRepository.findById(visaId)
                .orElseThrow(() -> new RuntimeException("Visa not found"));

        visa.setStatus(status);
        visa.setStatus(notes);

        return visaApplicationRepository.save(visa);
    }

    public List<VisaApplication> findByStatus(String status) {
        return visaApplicationRepository.findByStatus(status);
    }

    public List<VisaApplication> findByApplicantId(Long applicantId) {
        return visaApplicationRepository.findByApplicantId(applicantId);
    }
}

