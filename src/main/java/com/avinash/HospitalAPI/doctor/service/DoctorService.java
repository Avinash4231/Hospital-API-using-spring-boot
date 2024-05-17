package com.avinash.HospitalAPI.doctor.service;

import java.util.*;

import com.avinash.HospitalAPI.doctor.Entity.Doctor;

public interface DoctorService {
    List<Doctor> getAllDoctors();

    boolean updateDoctor(Doctor doctor, Long id);

    void addDoctor(Doctor doctor);

    boolean removeDoctor(Long id);

    Doctor getDoctorById(Long id);
}
