package com.example.VaccineNationBookingSystem.dto.request;

import com.example.VaccineNationBookingSystem.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PatientRequest {

    private String name;

    private int age;

    private Gender gender;

    private  String emailId;
}
