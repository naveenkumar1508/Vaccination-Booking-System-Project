package com.example.VaccineNationBookingSystem.service;

import com.example.VaccineNationBookingSystem.Enum.AppointmentStatus;
import com.example.VaccineNationBookingSystem.exception.DoctorNotFoundException;
import com.example.VaccineNationBookingSystem.exception.PatientNotFoundException;
import com.example.VaccineNationBookingSystem.model.Appointment;
import com.example.VaccineNationBookingSystem.model.Doctor;
import com.example.VaccineNationBookingSystem.model.Dose;
import com.example.VaccineNationBookingSystem.model.Patient;
import com.example.VaccineNationBookingSystem.repository.AppointmentRepository;
import com.example.VaccineNationBookingSystem.repository.DoctorRepository;
import com.example.VaccineNationBookingSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;
    public Appointment bookAppointment(int patientId, int doctorId) {

        Optional<Patient> optionalPatient = patientRepository.findById(patientId);

        if(optionalPatient.isEmpty()) {
            throw new PatientNotFoundException("Invalid Patient Id");
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

        if(optionalDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Invalid Doctor Id");
        }

        Patient patient = optionalPatient.get();
        Doctor doctor = optionalDoctor.get();

        //book the appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }
}
