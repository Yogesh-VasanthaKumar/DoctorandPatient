package com.application.DoctorPatient.Controller;

import com.application.DoctorPatient.Service.DoctorService;
import com.application.DoctorPatient.Service.PatientService;
import com.application.DoctorPatient.model.Doctor;
import com.application.DoctorPatient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

        @Autowired
        private DoctorService doctorService;
        @Autowired
        private PatientService patientService;

        @GetMapping("/doctor-suggestions/{patientId}")
        public List<Doctor> getDoctorSuggestions(@PathVariable("patientId") Long patientId) {

            Patient patient = patientService.getPatientById(patientId);

            List<Doctor> doctors = doctorService.getDoctorsByLocationAndSpeciality(patient.getCity(), patient.getSymptom());
            return doctors;

    }

}
