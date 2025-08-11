package com.example.VaccineNationBookingSystem.controller;

import com.example.VaccineNationBookingSystem.Enum.VaccineBrand;
import com.example.VaccineNationBookingSystem.model.Dose;
import com.example.VaccineNationBookingSystem.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/vaccinate")
    public Dose addDose(@RequestParam("id") int patientId,
                        @RequestParam("brand") VaccineBrand vaccineBrand) {


        return doseService.addDose(patientId, vaccineBrand);
    }

    //1) Make entity relationships
    //2) make doctor apis
    //3) make api to vaccinate a patient
}
