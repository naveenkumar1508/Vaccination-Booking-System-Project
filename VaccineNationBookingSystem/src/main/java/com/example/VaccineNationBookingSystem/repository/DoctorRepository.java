package com.example.VaccineNationBookingSystem.repository;

import com.example.VaccineNationBookingSystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
