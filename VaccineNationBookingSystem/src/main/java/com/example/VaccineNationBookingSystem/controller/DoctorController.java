package com.example.VaccineNationBookingSystem.controller;

import com.example.VaccineNationBookingSystem.model.Doctor;
import com.example.VaccineNationBookingSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;

@RestController
@RequestMapping("/doctor")
public class DoctorController {


    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor)
    {
        return doctorService.addDoctor(doctor);
    }

    //GET THE DOCTOR BY ID
}
