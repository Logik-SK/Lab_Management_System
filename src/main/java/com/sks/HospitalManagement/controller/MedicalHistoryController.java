package com.sks.HospitalManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sks.HospitalManagement.dto.MedicalHistoryTo;
import com.sks.HospitalManagement.model.MedicalHistory;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/medical-history")
public class MedicalHistoryController {
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<MedicalHistoryTo> getAllMedicalRecords() {
		return null;
	}

	/**
	 * 
	 * @param medicalHistory
	 * @return
	 */
	@PostMapping
	public ResponseEntity<MedicalHistory> postMethodName(@RequestBody MedicalHistory medicalHistory) {

		return null;
	}

	/**
	 * 
	 * @param mHid
	 * @return
	 */
	@GetMapping("/mHid")
	public ResponseEntity<MedicalHistoryTo> getMethodName(@PathVariable Long mHid) {
		return null;
	}

	/**
	 * 
	 * @param mHid
	 * @param medicalHistory
	 * @return
	 */
	@PutMapping("/{mHid}")
	public ResponseEntity<MedicalHistory> putMethodName(@PathVariable Long mHid,
			@RequestBody MedicalHistory medicalHistory) {

		return null;

	}

	/**
	 * 
	 * @param mHid
	 * @return
	 */
	@DeleteMapping("/mHid")
	public ResponseEntity<Void> deleteMedicalRecordById(@PathVariable Long mHid) {

		return null;
	}

}