package com.project.farmmanagement.repo;

import com.project.farmmanagement.model.Temperature;
import com.project.farmmanagement.model.Water;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaterRepo extends JpaRepository<Water, Long> {

    void deleteWaterById(Long id);

    Optional<Water> findWaterById(Long id);
}
