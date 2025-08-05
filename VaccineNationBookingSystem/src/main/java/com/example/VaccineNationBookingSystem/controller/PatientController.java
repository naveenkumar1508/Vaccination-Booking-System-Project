package com.example.VaccineNationBookingSystem.controller;

import com.example.VaccineNationBookingSystem.model.Patient;
import com.example.VaccineNationBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient") //this tells the common endpoint for all the apis
public class PatientController {


    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient) {

        try
        {
            patientService.addPatient(patient);
            return "Patient has been Added";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    @GetMapping("/get")
    public Patient getPatient(@RequestParam("id") int id)
    {
        return patientService.getPatient(id);
    }

}
