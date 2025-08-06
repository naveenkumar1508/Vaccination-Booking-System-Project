package com.example.VaccineNationBookingSystem.exception;

public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
