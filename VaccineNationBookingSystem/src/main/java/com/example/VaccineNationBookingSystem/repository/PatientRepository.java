package com.example.VaccineNationBookingSystem.repository;

import com.example.VaccineNationBookingSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    //the first argument i.e Patient is class to which you want to connect your repository second argument i.e Integer is the data type of the primary key
    //we always extends the JpaRepository
}
