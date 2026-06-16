package com.example.Spring.Object_Oriented.Programming.Services;

import com.example.Spring.Object_Oriented.Programming.Entity.Applicant;
import com.example.Spring.Object_Oriented.Programming.Entity.Interview;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementApplicant {

    private Applicant applicantRepository;
    private Interview interviewRepository;

    public ImplementApplicant(Applicant applicantRepository,
                              Interview interviewRepository) {
        this.Applicant = applicantRepository;
        this.Interview = interviewRepository;
    }

    public Applicant saveApplicant(Applicant applicant) {

        if (applicant.getFirstName() == null || applicant.getFirstName().isEmpty()) {
            throw new RuntimeException("First name is required");
        }

        if (applicant.getLastName() == null || applicant.getLastName().isEmpty()) {
            throw new RuntimeException("Last name is required");
        }

        if (applicant.getPassportNumber() == null || applicant.getPassportNumber().isEmpty()) {
            throw new RuntimeException("Passport number is required");
        }

        return applicantRepository.save(applicant);
    }

    public Applicant saveApplicant(String firstName,
                                   String lastName,
                                   String passportNumber,
                                   String nationality) {

        if (firstName == null || firstName.isEmpty()) {
            throw new RuntimeException("First name is required");
        }

        if (lastName == null || lastName.isEmpty()) {
            throw new RuntimeException("Last name is required");
        }

        if (passportNumber == null || passportNumber.isEmpty()) {
            throw new RuntimeException("Passport number is required");
        }

        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);
        applicant.setCriminalRecord(false);

        return applicantRepository.save(applicant);
    }

    public void flagCriminalRecord(Long applicantId) {

        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        applicant.setCriminalRecord(true);
        applicantRepository.save(applicant);

        List<Interview> interviews =
                interviewRepository.findByApplicantId(applicantId);

        for (Interview interview : interviews) {

            if (interview.getStatus() == InterviewStatus.SCHEDULED) {
                interview.setStatus(InterviewStatus.CANCELLED);
            }
        }

        interviewRepository.saveAll(interviews);
    }
}


