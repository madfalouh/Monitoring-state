package com.project.farmmanagement.repo;

import com.project.farmmanagement.model.SoilMoisture;
import com.project.farmmanagement.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoilMoistureRepo extends JpaRepository<SoilMoisture, Long> {

    void deleteSoilMoistureById(Long id);

    Optional<SoilMoisture> findSoilMoistureById(Long id);
}
