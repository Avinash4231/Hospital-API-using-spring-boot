package com.avinash.HospitalAPI.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avinash.HospitalAPI.patient.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
