package com.example.VaccineNationBookingSystem.dto.response;

import com.example.VaccineNationBookingSystem.Enum.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppointmentResponse {

    private String appointmentId;

    private Date dateOfAppointment;

    private AppointmentStatus Status;

    private PatientResponse patientResponse;

    private String doctorName;
}
