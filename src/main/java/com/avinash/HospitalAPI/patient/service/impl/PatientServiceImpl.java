package com.avinash.HospitalAPI.patient.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.HospitalAPI.doctor.Entity.Doctor;
import com.avinash.HospitalAPI.patient.Entity.Patient;
import com.avinash.HospitalAPI.patient.repository.PatientRepository;
import com.avinash.HospitalAPI.patient.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public boolean removePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public boolean updatePatient(Patient patient, Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            Patient patientToUpdate = patientOptional.get();
            patientToUpdate.setName(patient.getName());
            patientToUpdate.setCity(patient.getCity());
            patientToUpdate.setEmail(patient.getEmail());
            patientToUpdate.setPhoneNumber(patient.getPhoneNumber());
            patientToUpdate.setSymptom(patient.getSymptom());
            patientRepository.save(patientToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
