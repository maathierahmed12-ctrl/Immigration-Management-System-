package com.example.Spring.Object_Oriented.Programming.Repository;

import com.example.Spring.Object_Oriented.Programming.Entity.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CenterRepository extends JpaRepository<ImmigrationCenter, Long> {

    List<ImmigrationCenter> findByLocationCountry(String locationCountry);

    List<ImmigrationCenter> findByType(String type);
}