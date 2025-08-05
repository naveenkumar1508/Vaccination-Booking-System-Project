package com.example.VaccineNationBookingSystem.model;

import com.example.VaccineNationBookingSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //its like Auto-Increment
    private int id;

    private String name;

    private  int age;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private boolean vaccinated;

    @Column(unique = true, nullable = false)
    private String emailId;
}
