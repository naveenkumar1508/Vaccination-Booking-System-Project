package com.example.VaccineNationBookingSystem.model;

import com.example.VaccineNationBookingSystem.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp  //when this record is created in the database
    private Date dateOfAppointment;

    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

    @OneToOne
    @JoinColumn
    Patient patient;

}
