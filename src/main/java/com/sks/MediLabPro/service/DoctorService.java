package com.sks.HospitalManagement.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sks.HospitalManagement.model.Doctor;
import com.sks.HospitalManagement.repository.IDoctorRepository;

@Service
public class DoctorService {
	@Autowired
	IDoctorRepository doctorRepository;

	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	public Optional<Doctor> findDoctorById(long doctorId) {
		return doctorRepository.findById(doctorId);
	}

	public Doctor updateDoctor(Long doctorId, Doctor updatedDoctor) {
		Doctor existingDoctor = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new NoSuchElementException("Doctor not found with ID: " + doctorId));
		if (StringUtils.hasText(updatedDoctor.getName())) {
			existingDoctor.setName(null);
		}
		if (StringUtils.hasLength(updatedDoctor.getSpecialization())) {
			existingDoctor.setSpecialization(null);
		}
		return doctorRepository.save(existingDoctor);

	}

}
