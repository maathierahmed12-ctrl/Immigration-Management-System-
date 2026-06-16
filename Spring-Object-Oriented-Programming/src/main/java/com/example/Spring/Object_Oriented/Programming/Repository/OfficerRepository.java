package com.example.Spring.Object_Oriented.Programming.Repository;

import com.example.Spring.Object_Oriented.Programming.Entity.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository<ImmigrationOfficer, Long> {

    List<ImmigrationOfficer> findByRank(String rank);

    List<ImmigrationOfficer> findByActive(boolean active);
}
