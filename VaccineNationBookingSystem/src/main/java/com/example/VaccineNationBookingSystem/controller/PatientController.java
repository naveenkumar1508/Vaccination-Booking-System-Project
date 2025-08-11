package com.example.VaccineNationBookingSystem.controller;

import com.example.VaccineNationBookingSystem.Enum.Gender;
import com.example.VaccineNationBookingSystem.dto.request.PatientRequest;
import com.example.VaccineNationBookingSystem.dto.response.PatientResponse;
import com.example.VaccineNationBookingSystem.model.Patient;
import com.example.VaccineNationBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient") //this tells the common endpoint for all the apis
public class PatientController {


    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody PatientRequest patientRequest) {

        try
        {
           PatientResponse patientResponse =  patientService.addPatient(patientRequest);
            return new ResponseEntity(patientResponse, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity("invalid request", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public PatientResponse getPatient(@RequestParam("id") int id)
    {
        return patientService.getPatient(id);
    }


    //get all the patients of a particular gender
    @GetMapping("/get/gender/{gender}")
    public List<PatientResponse> getAllPatientsByGender(@PathVariable("gender") Gender gender) {

        return patientService.getAllPatientsByGender(gender);
    }


    //get all the vaccinated patients above age 30

    //get all unvaccinated MALES/FEMALES

    //change the vaccinated status for all the patients 1-> 0 and 0-> 1
}
