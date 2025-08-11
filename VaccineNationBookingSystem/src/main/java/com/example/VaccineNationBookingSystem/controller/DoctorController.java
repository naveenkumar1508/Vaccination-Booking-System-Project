package com.example.VaccineNationBookingSystem.controller;

import com.example.VaccineNationBookingSystem.model.Doctor;
import com.example.VaccineNationBookingSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //Delete the doctor by id
    @DeleteMapping("/delete")
    public String deleteDoctor(@RequestParam("id") int id) {
        return doctorService.deleteDoctor(id);
    }
}
