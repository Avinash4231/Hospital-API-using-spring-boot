package com.avinash.HospitalAPI.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.avinash.HospitalAPI.doctor.Entity.Doctor;
import com.avinash.HospitalAPI.doctor.Entity.Speciality;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);
}
