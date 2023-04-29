package com.application.DoctorPatient.Controller;

import com.application.DoctorPatient.Repository.DoctorRepository;
import com.application.DoctorPatient.Repository.PatientRepository;
import com.application.DoctorPatient.model.Doctor;
import com.application.DoctorPatient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/{patientId}/suggest-doctors")
    public ResponseEntity<List<Doctor>> suggestDoctors(@PathVariable("patientId") Long patientId) {
        // find the patient by ID
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (!patientOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Patient patient = patientOptional.get();


        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(patient.getCity(), patient.getSymptom());
        if (doctors.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(doctors);
    }
}

