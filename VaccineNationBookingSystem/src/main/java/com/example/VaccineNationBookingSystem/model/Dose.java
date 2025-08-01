package com.example.VaccineNationBookingSystem.model;

import com.example.VaccineNationBookingSystem.Enum.VaccineBrand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNumber;

    @Enumerated(value = EnumType.STRING)
    private VaccineBrand vaccineBrand;

    private boolean taken;

    private Date dateOfVaccination;
}
