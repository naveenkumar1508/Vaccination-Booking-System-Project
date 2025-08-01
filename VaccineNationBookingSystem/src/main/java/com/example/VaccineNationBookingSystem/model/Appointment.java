package com.example.VaccineNationBookingSystem.model;

import com.example.VaccineNationBookingSystem.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String appointmentId;

    private Date dateOfAppointment;

    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus status;

}
