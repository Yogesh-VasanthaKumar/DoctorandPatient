package com.application.DoctorPatient.Service;

import com.application.DoctorPatient.Repository.DoctorRepository;
import com.application.DoctorPatient.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getDoctorsByLocationAndSpeciality(String location, String symptom) {
        // code to query database for doctors with matching location and speciality
        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(location, symptom);
        return doctors;
    }
}
