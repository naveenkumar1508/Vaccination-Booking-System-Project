package com.example.VaccineNationBookingSystem.service;

import com.example.VaccineNationBookingSystem.Enum.VaccineBrand;
import com.example.VaccineNationBookingSystem.exception.PatientNotFoundException;
import com.example.VaccineNationBookingSystem.model.Dose;
import com.example.VaccineNationBookingSystem.model.Patient;
import com.example.VaccineNationBookingSystem.repository.DoseRepository;
import com.example.VaccineNationBookingSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {


    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PatientRepository patientRepository;

    public Dose addDose(int patientId, VaccineBrand vaccineBrand) {

        //1.check whether patient is valid or not
    Optional<Patient> PatientOptional = patientRepository.findById(patientId);
    if(PatientOptional.isEmpty())
    {
        throw new PatientNotFoundException("Invalid patient id");
    }

        Patient patient = PatientOptional.get();

        if(patient.isVaccinated())
        {
            throw new RuntimeException("Patient is already Vaccinated");
        }

        patient.setVaccinated(true);

        Dose dose = new Dose();
        dose.setVaccineBrand(vaccineBrand);
        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));
        dose.setPatient(patient);  //SETTING THE FOREIGN KEY

        patientRepository.save(patient);
        return doseRepository.save(dose);
    }
}
