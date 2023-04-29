package com.application.DoctorPatient.Service;

import com.application.DoctorPatient.Repository.PatientRepository;
import com.application.DoctorPatient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient getPatientById(Long id) {
        // code to query database for patient by ID
        Patient patient = patientRepository.findById(id).orElse(null);
        return patient;
    }
}

