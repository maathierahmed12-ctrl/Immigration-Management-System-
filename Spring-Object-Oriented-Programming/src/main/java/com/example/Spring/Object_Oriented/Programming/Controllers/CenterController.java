package com.example.Spring.Object_Oriented.Programming.Controllers;

import com.example.Spring.Object_Oriented.Programming.Entity.ImmigrationCenter;
import com.example.Spring.Object_Oriented.Programming.Repository.CenterRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/centers")
public class CenterController {

    private final CenterRepository centerRepository;

    public CenterController(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    @PostMapping
    public ImmigrationCenter createCenter(@RequestBody ImmigrationCenter center) {
        return centerRepository.save(center);
    }

    @GetMapping("/{id}")
    public ImmigrationCenter getCenterById(@PathVariable Long id) {
        return centerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Center not found"));
    }
}