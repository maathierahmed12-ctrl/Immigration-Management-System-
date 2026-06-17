package com.example.Spring.Object_Oriented.Programming.Services;

import com.example.Spring.Object_Oriented.Programming.DTO.ApplicantDTO;
import com.example.Spring.Object_Oriented.Programming.Entity.Applicant;
import com.example.Spring.Object_Oriented.Programming.Entity.AsylumSeeker;
import com.example.Spring.Object_Oriented.Programming.Entity.Interview;
import com.example.Spring.Object_Oriented.Programming.Repository.ApplicantRepository;
import com.example.Spring.Object_Oriented.Programming.Repository.InterviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementApplicant {

    private ApplicantRepository applicantRepository;
    private InterviewRepository interviewRepository;

    public ImplementApplicant(ApplicantRepository applicantRepository,
                              InterviewRepository interviewRepository) {

        this.applicantRepository = applicantRepository;
        this.interviewRepository = interviewRepository;
    }

    public Applicant saveApplicant(AsylumSeeker applicant) {

        if (applicant.getFirstName() == null || applicant.getFirstName().isEmpty()) {
            throw new RuntimeException("First name is required");
        }

        if (applicant.getLastName() == null || applicant.getLastName().isEmpty()) {
            throw new RuntimeException("Last name is required");
        }

        if (applicant.getEmail() == null || applicant.getPhoneNumber().isEmpty()) {
            throw new RuntimeException("Passport number is required");
        }

        Applicant newApplicant = new Applicant();
        newApplicant.setFirstName(applicant.getFirstName());
        newApplicant.setLastName(applicant.getLastName());
        newApplicant.setPhoneNumber(applicant.getPhoneNumber());
        newApplicant.setFirstName(applicant.getFirstName());
        newApplicant.setGender(String.valueOf(false));

        return applicantRepository.save(newApplicant);
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
        applicant.setFirstName(passportNumber);
        applicant.setPhoneNumber(nationality);
        applicant.setFirstName(String.valueOf(false));

        return applicantRepository.save(applicant);
    }

    public void flagCriminalRecord(Long applicantId) {

        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        applicant.setPhoneNumber(String.valueOf(true));
        applicantRepository.save(applicant);

        List<Interview> interviews =
                interviewRepository.findAll();

        for (Interview interview : interviews) {

            if (interview.getFirstName() == Interview.SCHEDULED) {
                interview.getEmail(Interview.CANCELLED);
            }
        }

        interviewRepository.saveAll(interviews);
    }

    public ApplicantDTO saveApplicant(ApplicantDTO dto) {

        Applicant applicant = new Applicant();

        applicant.setFirstName(dto.getFirstName());
        applicant.setLastName(dto.getLastName());
        applicant.setPhoneNumber(dto.getPassportNumber());
        applicant.setGender(dto.getNationality());
        applicant.setPhoneNumber(dto.getPhoneNumber());
        applicant.setLastName(String.valueOf(false));

        Applicant savedApplicant = applicantRepository.save(applicant);

        ApplicantDTO response = new ApplicantDTO();

        response.setFirstName(savedApplicant.getFirstName());
        response.setLastName(savedApplicant.getLastName());
        response.setPassportNumber(savedApplicant.getPhoneNumber());
        response.setNationality(savedApplicant.getEmail());
        response.setPhoneNumber(savedApplicant.getPhoneNumber());
        return response;
    }

}