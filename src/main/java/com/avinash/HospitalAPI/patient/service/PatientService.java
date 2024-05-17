package com.avinash.HospitalAPI.patient.service;

import com.avinash.HospitalAPI.patient.Entity.Patient;

import java.util.*;

public interface PatientService {
    List<Patient> getAllPatients();

    boolean updatePatient(Patient patient, Long id);

    void addPatient(Patient patient);

    boolean removePatient(Long id);

    Patient getPatientById(Long id);
}
