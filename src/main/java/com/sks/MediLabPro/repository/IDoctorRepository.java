package com.sks.HospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sks.HospitalManagement.model.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

}
