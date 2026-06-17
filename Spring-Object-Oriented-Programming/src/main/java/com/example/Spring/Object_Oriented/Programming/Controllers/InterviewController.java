package com.example.Spring.Object_Oriented.Programming.Controllers;

import com.example.Spring.Object_Oriented.Programming.DTO.InterviewDTO;
import com.example.Spring.Object_Oriented.Programming.Services.InterviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }
    @PostMapping("/schedule")
    public InterviewDTO scheduleInterview(@RequestBody InterviewDTO dto) {
        return interviewService.scheduleInterview(dto);
    }

    @PutMapping("/{id}/complete")
    public InterviewDTO completeInterview(@PathVariable Long id) {
        return interviewService.completeInterview(id);
    }

    @PutMapping("/{id}/cancel")
    public InterviewDTO cancelInterview(@PathVariable Long id) {
        return interviewService.cancelInterview(id);
    }

    @GetMapping("/applicant/{applicantId}")
    public List<InterviewDTO> getApplicantInterviews(@PathVariable Long applicantId) {
        return interviewService.getOfficerSchedule(applicantId);
    }

    @GetMapping("/officer/{officerId}/date/{date}")
    public List<InterviewDTO> getOfficerSchedule(@PathVariable Long officerId,
                                                 @PathVariable String date) {
        return interviewService.getOfficerSchedule(officerId, date);
    }
}
