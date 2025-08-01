package com.example.VaccineNationBookingSystem.service;

import com.example.VaccineNationBookingSystem.model.Patient;
import com.example.VaccineNationBookingSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {


    @Autowired
    PatientRepository patientRepository;
    public void addPatient(Patient patient) {
        patientRepository.save(patient); // returns saved patient
    }
}
