package com.example.Spring.Object_Oriented.Programming.Services;

import com.example.Spring.Object_Oriented.Programming.DTO.InterviewDTO;
import com.example.Spring.Object_Oriented.Programming.Entity.Applicant;
import com.example.Spring.Object_Oriented.Programming.Entity.Interview;
import com.example.Spring.Object_Oriented.Programming.Repository.InterviewRepository;
import com.example.Spring.Object_Oriented.Programming.Repository.OfficerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final ImplementApplicant applicantRepository;
    private final OfficerRepository officerRepository;

    public InterviewService(InterviewRepository interviewRepository,
                            ImplementApplicant applicantRepository,
                            OfficerRepository officerRepository) {
        this.interviewRepository = interviewRepository;
        this.applicantRepository = applicantRepository;
        this.officerRepository = officerRepository;
    }

    public Interview scheduleInterview(Long applicantId,
                                       Long officerId,
                                       LocalDateTime dateTime) {

        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        OfficerService officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        boolean isBooked = interviewRepository
                .existsByOfficerIdAndInterviewDateTime(officerId, dateTime);

        if (isBooked) {
            throw new RuntimeException("Officer already booked");
        }

        Interview interview = new Interview();

        interview.setApplicant(applicant);
        interview.setOfficer(officer);
        interview.setInterviewDate(dateTime);
        interview.setStatus(Interview);

        return interviewRepository.save(interview);
    }

    public Interview completeInterview(Long id) {

        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        interview.setStatus(Interview.CANCELLED);

        return interviewRepository.save(interview);
    }

    public Interview cancelInterview(Long id) {

        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        interview.setStatus(Interview.CANCELLED);

        return interviewRepository.save(interview);
    }

    public List<Interview> getOfficerSchedule(Long officerId,
                                              LocalDate date) {

        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);

        return interviewRepository.findByOfficerIdAndInterviewDateTimeBetween(officerId, start, end);
    }

    public InterviewDTO scheduleInterview(InterviewDTO dto) {

        Applicant applicant = applicantRepository.findById(dto.getApplicantId())
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        Interview interview = interview(dto, applicant);

        Interview saved = interviewRepository.save(interview);

        return interview(saved);
    }

    private Interview interview(InterviewDTO dto, Applicant applicant) {
        return null;
    }
}