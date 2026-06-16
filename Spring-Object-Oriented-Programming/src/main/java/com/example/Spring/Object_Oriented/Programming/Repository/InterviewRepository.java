package com.example.Spring.Object_Oriented.Programming.Repository;

import com.example.Spring.Object_Oriented.Programming.Entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    boolean existsByOfficerIdAndInterviewDateTime(Long officerId, LocalDateTime dateTime);

    List<Interview> findByOfficerIdAndInterviewDateTimeBetween(
            Long officerId,
            LocalDateTime start,
            LocalDateTime end
    );
}
