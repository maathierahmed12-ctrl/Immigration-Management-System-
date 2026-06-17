package com.example.Spring.Object_Oriented.Programming.Services;

import com.example.Spring.Object_Oriented.Programming.DTO.VisaApplicantDTO;
import com.example.Spring.Object_Oriented.Programming.Entity.Applicant;
import com.example.Spring.Object_Oriented.Programming.Entity.ImmigrationCenter;
import com.example.Spring.Object_Oriented.Programming.Entity.ImmigrationOfficer;
import com.example.Spring.Object_Oriented.Programming.Repository.ApplicantRepository;
import com.example.Spring.Object_Oriented.Programming.Repository.CenterRepository;
import com.example.Spring.Object_Oriented.Programming.Repository.OfficerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisaApplicationService {

    private final OfficerRepository officerRepository;
    private final CenterRepository centerRepository;
    private final ApplicantRepository applicantRepository;

    public VisaApplicationService(OfficerRepository officerRepository,
                                  CenterRepository centerRepository,
                                  ApplicantRepository applicantRepository) {

        this.officerRepository = officerRepository;
        this.centerRepository = centerRepository;
        this.applicantRepository = applicantRepository;
    }

    public ImmigrationOfficer promoteOfficer(Long officerId,
                                             String newRank,
                                             int newClearanceLevel) {

        if (newClearanceLevel < 1 || newClearanceLevel > 5) {
            throw new RuntimeException("Clearance level must be between 1 and 5");
        }

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        officer.setRank(newRank);
        officer.setClearanceLevel(String.valueOf(newClearanceLevel));

        return officerRepository.save(officer);
    }

    public ImmigrationOfficer transferOfficer(Long officerId,
                                              Long newCenterId) {

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        ImmigrationCenter center = centerRepository.findById(newCenterId)
                .orElseThrow(() -> new RuntimeException("Center not found"));

        officer.setCenter(center);

        return officerRepository.save(officer);
    }

    public List<ImmigrationOfficer> findOfficersByRank(String rank) {
        return officerRepository.findByRank(rank);
    }

    public List<ImmigrationOfficer> findOfficersByRank(String rank,
                                                       int minimumClearanceLevel) {

        List<ImmigrationOfficer> officers = officerRepository.findByRank(rank);

        List<ImmigrationOfficer> filtered = new ArrayList<>();

        for (ImmigrationOfficer officer : officers) {

            int level = Integer.parseInt(officer.getClearanceLevel());

            if (level >= minimumClearanceLevel) {
                filtered.add(officer);
            }
        }

        return filtered;
    }

    public VisaApplicantDTO saveApplicant(VisaApplicantDTO dto) {

        Applicant applicant = new Applicant();

        applicant.setFirstName(dto.getFirstName());
        applicant.setLastName(dto.getLastName());
        applicant.setPhoneNumber(dto.getPassportNumber());
        applicant.setFirstName(dto.getNationality());
        applicant.setPhoneNumber(dto.getPhoneNumber());

        Applicant saved = applicantRepository.save(applicant);

        VisaApplicantDTO response = new VisaApplicantDTO();

        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());
        response.setPassportNumber(saved.getPhoneNumber());
        response.setNationality(saved.getEmail());
        response.setPhoneNumber(saved.getPhoneNumber());

        return response;
    }


}
