package com.example.Spring.Object_Oriented.Programming.Services;

import com.example.Spring.Object_Oriented.Programming.Entity.ImmigrationCenter;
import com.example.Spring.Object_Oriented.Programming.Entity.ImmigrationOfficer;
import com.example.Spring.Object_Oriented.Programming.Repository.CenterRepository;
import com.example.Spring.Object_Oriented.Programming.Repository.OfficerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisaApplicationService {

    private final OfficerRepository officerRepository;
    private final CenterRepository centerRepository;

    public VisaApplicationService(OfficerRepository officerRepository,
                                  CenterRepository centerRepository) {
        this.officerRepository = officerRepository;
        this.centerRepository = centerRepository;
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
}
