package com.example.VaccineNationBookingSystem.repository;

import com.example.VaccineNationBookingSystem.model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose, Integer> {
}
