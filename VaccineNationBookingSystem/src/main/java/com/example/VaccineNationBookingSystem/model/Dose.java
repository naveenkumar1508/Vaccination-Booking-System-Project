package com.example.VaccineNationBookingSystem.model;

import com.example.VaccineNationBookingSystem.Enum.VaccineBrand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    private Date dateOfVaccination;

    @OneToOne        //1st One -> Dose(Current), 2nd One - patient(connecting)
    @JoinColumn //create the foreign key column patient_id
    Patient patient;
}
