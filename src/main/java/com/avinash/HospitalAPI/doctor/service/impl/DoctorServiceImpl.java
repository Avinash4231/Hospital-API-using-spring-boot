package com.avinash.HospitalAPI.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.avinash.HospitalAPI.doctor.Entity.Doctor;
import com.avinash.HospitalAPI.doctor.Entity.Speciality;
import com.avinash.HospitalAPI.doctor.repository.DoctorRepository;
import com.avinash.HospitalAPI.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public boolean removeDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Doctor> suggestDoctors(String city, Speciality speciality) {
        return doctorRepository.findByCityAndSpeciality(city, speciality);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public boolean updateDoctor(Doctor doctor, Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            Doctor doctorToUpdate = doctorOptional.get();
            doctorToUpdate.setName(doctor.getName());
            doctorToUpdate.setCity(doctor.getCity());
            doctorToUpdate.setEmail(doctor.getEmail());
            doctorToUpdate.setPhoneNumber(doctor.getPhoneNumber());
            doctorToUpdate.setSpeciality(doctor.getSpeciality());
            doctorRepository.save(doctorToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
}
