package com.sks.HospitalManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.sks.HospitalManagement.dto.PatientTo;
import com.sks.HospitalManagement.model.Patient;
import com.sks.HospitalManagement.repository.IAppointmentRepository;
import com.sks.HospitalManagement.repository.IPatientRepository;

import jakarta.transaction.Transactional;

@Service
public class PatientService {
	@Autowired
	IPatientRepository patientRepository;

	public List<Patient> getAllPatients() {

		return patientRepository.findAll();
	}

	public Patient addPatient(Patient patient) {

		return patientRepository.save(patient);
	}

	public boolean deletePatient(Long pId) {
		if (patientRepository.existsById(pId)) {
			patientRepository.deleteById(pId);
			return true;
		}
		return false;

	}

	public Patient updatePatient(Long id, Patient UpdatedPatient) {
		// Fetch the existing patient

		Patient existingPatient = patientRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Patient not found with ID: " + id));

		if (StringUtils.hasText(UpdatedPatient.getName())) {
			existingPatient.setName(UpdatedPatient.getName());
		}
		if (StringUtils.hasText(UpdatedPatient.getDepartment())) {
			existingPatient.setDepartment(UpdatedPatient.getDepartment());
		}
		if (StringUtils.hasText(UpdatedPatient.getStatus())) {
			existingPatient.setStatus(UpdatedPatient.getStatus());
		}
		if (UpdatedPatient.getAge() != 0) {
			existingPatient.setAge(UpdatedPatient.getAge());
		}
		if (UpdatedPatient.getDischargeDate() != null) {
			existingPatient.setDischargeDate(UpdatedPatient.getDischargeDate());
		}
		return patientRepository.save(existingPatient);

	}

	public Optional<Patient> findByPatientId(Long patientId) {
		return patientRepository.findById(patientId);

	}

	public List<PatientTo> searchPatientByName(String pName) {
		if (!StringUtils.hasText(pName)) {
			return new ArrayList<PatientTo>();
		}
		List<Patient> patientList = patientRepository.findByNameContainingIgnoreCase(pName);
		List<PatientTo> patientToList = new ArrayList<PatientTo>();
		Optional.ofNullable(patientList).ifPresent(pL -> {
			pL.forEach(p -> {
				patientToList.add(new PatientTo(p.getName(), p.getAge(), p.getStatus(), null, null, null, null, null,
						null, null));
			});
		});
		return patientToList;

	}

}
