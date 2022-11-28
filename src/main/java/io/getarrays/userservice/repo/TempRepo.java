package io.getarrays.userservice.repo;

import io.getarrays.userservice.domain.Temp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TempRepo extends JpaRepository<Temp, Long> {
}
