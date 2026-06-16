package com.example.Spring.Object_Oriented.Programming.Repository;

import com.example.Spring.Object_Oriented.Programming.Entity.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication, Long> {

    List<VisaApplication> findByStatus(String status);

    List<VisaApplication> findByVisaType(String visaType);

    List<VisaApplication> findByApplicantId(Long applicantId);

    List<VisaApplication> findByHandlingOfficerId(Long officerId);
}
