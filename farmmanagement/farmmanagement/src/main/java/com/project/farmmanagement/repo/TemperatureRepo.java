package com.project.farmmanagement.repo;

import com.project.farmmanagement.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemperatureRepo extends JpaRepository<Temperature, Long> {

    void deleteTemperatureById(Long id);

    Optional<Temperature> findTemperatureById(Long id);
}
