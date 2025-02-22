package com.sks.HospitalManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sks.HospitalManagement.dto.PatientTo;
import com.sks.HospitalManagement.model.Billing;
import com.sks.HospitalManagement.model.MedicalHistory;
import com.sks.HospitalManagement.model.Patient;
import com.sks.HospitalManagement.service.PatientService;

@RestController
@RequestMapping("api/patients")
public class PatientController {
	@Autowired
	PatientService patientService;

	/**
	 * 
	 * @return all patient list
	 */
	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatients() {
		Optional<List<Patient>> patients = Optional.ofNullable(patientService.getAllPatients());

		return patients.filter(list -> !list.isEmpty()).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.noContent().build());
	}

	/**
	 * 
	 * @param patient
	 * @return added patient
	 */
	@PostMapping
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Optional<Patient> addedPatient = Optional.ofNullable(patientService.addPatient(patient));

		if (addedPatient.isPresent()) {
			return ResponseEntity.ok(addedPatient.get()); // Return the added patient
		} else {
			return ResponseEntity.badRequest().build(); // 400 Bad Request if adding fails
		}
	}

	/**
	 * 
	 * @param pId
	 * @param patient
	 * @return updated Patient
	 */
	@PutMapping("/{pId}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long pId, @RequestBody Patient patient) {
		// Attempt to update the patient using the service
		Optional<Patient> updatedPatient = Optional.ofNullable(patientService.updatePatient(pId, patient));

		if (updatedPatient.isPresent()) {
			return ResponseEntity.ok(updatedPatient.get()); // Return the updated patient
		} else {
			return ResponseEntity.notFound().build(); // 404 Not Found if the patient doesn't exist
		}
	}

	/**
	 * 
	 * @param pId
	 * @return found patient by id
	 */
	@GetMapping("/{pId}")
	public ResponseEntity<Patient> findByPatientId(@PathVariable Long pId) {
		Optional<Patient> patient = patientService.findByPatientId(pId);
		return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());

	}

	/**
	 * 
	 * @param pId
	 * @return true if patient deleted else return false
	 */
	@DeleteMapping("/{pId}")
	public ResponseEntity<Void> deleteByPatientID(@PathVariable Long pId) {
		boolean patientDeleted = patientService.deletePatient(pId);
		if (patientDeleted)
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();

	}

	/**
	 * 
	 * @param pName
	 * @return
	 */
	@GetMapping("/search")
	public ResponseEntity<List<PatientTo>> searchPatientByName(@RequestParam String pName) {
		Optional<List<PatientTo>> patientlistOptional = Optional.ofNullable(patientService.searchPatientByName(pName));
		return patientlistOptional.filter(pL -> !pL.isEmpty()).map(ResponseEntity::ok)
				.orElse(ResponseEntity.noContent().build());
	}

	/**
	 * 
	 * @param Pid
	 * @return
	 */
	@GetMapping("/{pId}/medical-history")
	public ResponseEntity<List<MedicalHistory>> gePatientMedicalHistory(@PathVariable Long Pid) {
		return null;
		// this method to fetch medical history

	}

	/**
	 * 
	 * @param Pid
	 * @return
	 */
	@PostMapping("/{pId}/medical-history")
	public ResponseEntity<List<MedicalHistory>> addPatientMedicalHistory(@PathVariable Long Pid) {

		return null;
	}

	/**
	 * 
	 * @param Pid
	 * @return
	 */
	@GetMapping("/{id}/billing")
	public ResponseEntity<List<Billing>> getPatientBills(@PathVariable Long pId) {
		return null;
	}

}
