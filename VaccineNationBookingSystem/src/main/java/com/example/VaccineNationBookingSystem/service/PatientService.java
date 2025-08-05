package com.example.VaccineNationBookingSystem.service;

import com.example.VaccineNationBookingSystem.exception.PatientNotFoundException;
import com.example.VaccineNationBookingSystem.model.Patient;
import com.example.VaccineNationBookingSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {


    @Autowired
    PatientRepository patientRepository;
    public void addPatient(Patient patient) {
        patientRepository.save(patient); // returns saved patient
    }

    public Patient getPatient(int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id); // searches based on primarykey

        if(optionalPatient.isEmpty())
        {
            throw new PatientNotFoundException("Invalid Patient id");
        }

        Patient patient = optionalPatient.get();
        return patient;
    }
}
