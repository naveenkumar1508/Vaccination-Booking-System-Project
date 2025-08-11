package com.example.VaccineNationBookingSystem.service;

import com.example.VaccineNationBookingSystem.Enum.Gender;
import com.example.VaccineNationBookingSystem.dto.request.PatientRequest;
import com.example.VaccineNationBookingSystem.dto.response.PatientResponse;
import com.example.VaccineNationBookingSystem.exception.PatientNotFoundException;
import com.example.VaccineNationBookingSystem.model.Patient;
import com.example.VaccineNationBookingSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {


    @Autowired
    PatientRepository patientRepository;

    public  List<PatientResponse> getAllPatientsByGender(Gender gender) {

         List<Patient> patients = patientRepository.findAll();

         List<PatientResponse> patientResponses = new ArrayList<>();
         for(Patient patient : patients)
         {

             if(patient.getGender() == gender) {
                 PatientResponse patientResponse = new PatientResponse();
                 patientResponse.setName(patient.getName());
                 patientResponse.setVaccinated(patient.isVaccinated());
                 patientResponse.setEmailId(patient.getEmailId());

                 patientResponses.add(patientResponse);
             }
         }

        return patientResponses;
    }

    public PatientResponse addPatient(PatientRequest patientRequest) {

        //1. Request dto -> Model entity
        Patient patient = new Patient();
        patient.setVaccinated(false);
        patient.setAge(patientRequest.getAge());
        patient.setName(patientRequest.getName());
        patient.setGender(patientRequest.getGender());
        patient.setEmailId(patientRequest.getEmailId());

        Patient savedPatient = patientRepository.save(patient); // returns saved patient


        //2 convert model -> response dto
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(savedPatient.getName());
        patientResponse.setVaccinated(savedPatient.isVaccinated());
        patientResponse.setEmailId(savedPatient.getEmailId());

        return patientResponse;
    }

    public PatientResponse getPatient(int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id); // searches based on primarykey

        if(optionalPatient.isEmpty())
        {
            throw new PatientNotFoundException("Invalid Patient id");
        }

        Patient patient = optionalPatient.get();

        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(patient.getName());
        patientResponse.setVaccinated(patient.isVaccinated());
        patientResponse.setEmailId(patient.getEmailId());

        return patientResponse;
    }
}
