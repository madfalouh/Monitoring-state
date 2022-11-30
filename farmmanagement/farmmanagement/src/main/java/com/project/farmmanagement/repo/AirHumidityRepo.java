package com.project.farmmanagement.repo;

import com.project.farmmanagement.model.AirHumidity;
import com.project.farmmanagement.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirHumidityRepo extends JpaRepository<AirHumidity, Long> {

    void deleteAirHumidityById(Long id);

    Optional<AirHumidity> findAirHumidityById(Long id);
}
