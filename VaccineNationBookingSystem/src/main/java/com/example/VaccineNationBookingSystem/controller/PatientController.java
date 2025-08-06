package com.example.VaccineNationBookingSystem.controller;

import com.example.VaccineNationBookingSystem.model.Patient;
import com.example.VaccineNationBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient") //this tells the common endpoint for all the apis
public class PatientController {


    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody Patient patient) {

        try
        {
           Patient savedPatient =  patientService.addPatient(patient);
            return new ResponseEntity(savedPatient, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity("invalid request", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public Patient getPatient(@RequestParam("id") int id)
    {
        return patientService.getPatient(id);
    }

}
