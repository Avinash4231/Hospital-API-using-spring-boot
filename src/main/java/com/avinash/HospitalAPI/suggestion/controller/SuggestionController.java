package com.avinash.HospitalAPI.suggestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.avinash.HospitalAPI.doctor.Entity.Doctor;
import com.avinash.HospitalAPI.doctor.Entity.Speciality;
import com.avinash.HospitalAPI.doctor.service.impl.DoctorServiceImpl;
import com.avinash.HospitalAPI.patient.Entity.Patient;
import com.avinash.HospitalAPI.patient.Entity.Symptom;
import com.avinash.HospitalAPI.patient.service.impl.PatientServiceImpl;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {
    @Autowired
    private PatientServiceImpl patientService;
    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping("/{patientId}")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }

        List<Doctor> doctors = doctorService.suggestDoctors(patient.getCity(), getSpeciality(patient.getSymptom()));
        if (doctors.isEmpty()) {
            if (!Arrays.asList("Delhi", "Noida", "Faridabad").contains(patient.getCity())) {
                return ResponseEntity.ok("We are still waiting to expand to your location");
            } else {
                return ResponseEntity.ok("There isn’t any doctor present at your location for your symptom");
            }
        }
        return ResponseEntity.ok(doctors);
    }

    private Speciality getSpeciality(Symptom symptom) {
        switch (symptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                return Speciality.ORTHOPEDIC;
            case DYSMENORRHEA:
                return Speciality.GYNECOLOGY;
            case SKIN_INFECTION:
            case SKIN_BURN:
                return Speciality.DERMATOLOGY;
            case EAR_PAIN:
                return Speciality.ENT;
            default:
                throw new IllegalArgumentException("Unknown symptom: " + symptom);
        }
    }
}
