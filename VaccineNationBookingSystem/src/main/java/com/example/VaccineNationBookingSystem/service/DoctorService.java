package com.example.VaccineNationBookingSystem.service;

import com.example.VaccineNationBookingSystem.controller.DoctorController;
import com.example.VaccineNationBookingSystem.model.Doctor;
import com.example.VaccineNationBookingSystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {


    @Autowired
    DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor) {

        doctorRepository.save(doctor);
        return "Doctor Saved Successfully";
    }

    public String  deleteDoctor(int id) {
        doctorRepository.deleteById(id);
        return "Docter has been deleted";
    }
}
