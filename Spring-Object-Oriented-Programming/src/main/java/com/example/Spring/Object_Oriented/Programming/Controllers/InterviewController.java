package com.example.Spring.Object_Oriented.Programming.Controllers;

import com.example.Spring.Object_Oriented.Programming.Repository.InterviewRepository;
import com.example.Spring.Object_Oriented.Programming.Services.InterviewService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

        private final InterviewService interviewService;

        public InterviewController(InterviewService interviewService) {
            this.interviewService = interviewService;
        }

        @PostMapping("/schedule/{applicantId}/{officerId}")
        public InterviewRepository scheduleInterview(@PathVariable Long applicantId,
                                                     @PathVariable Long officerId,
                                                     @RequestParam String date) {

            return interviewService.scheduleInterview(applicantId, officerId, LocalDateTime.parse(date));
        }

        @PutMapping("/{id}/complete")
        public InterviewRepository completeInterview(@PathVariable Long id) {

            return interviewService.completeInterview(id);
        }

        @PutMapping("/{id}/cancel")
        public InterviewRepository cancelInterview(@PathVariable Long id) {

            return interviewService.cancelInterview(id);
        }

        @GetMapping("/officer/{officerId}/date/{date}")
        public List<InterviewRepository> getOfficerSchedule(@PathVariable Long officerId,
                                                            @PathVariable String date) {

            LocalDate localDate = LocalDate.parse(date);

            return interviewService.getOfficerSchedule(officerId, localDate);
        }
    }



