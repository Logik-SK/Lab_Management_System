package com.sks.HospitalManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sks.HospitalManagement.model.Billing;

@RestController
@RequestMapping("/billing")
public class BillingController {
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Billing> getAllBilling() {
		return null;
	}

	/**
	 * 
	 * @param billing
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Billing> addBilling(@RequestBody Billing billing) {

		return null;
	}

	/**
	 * 
	 * @param bID
	 * @return
	 */
	@GetMapping("/bId")
	public ResponseEntity<Billing> getBillingById(@PathVariable Long bID) {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/pending")
	public ResponseEntity<Billing> getAllPendingBilling() {
		return null;
	}

	/**
	 * 
	 * @param bId
	 * @param billing
	 * @return
	 */
	@PutMapping("/{bId}")
	public ResponseEntity<Billing> putMethodName(@PathVariable Long bId, @RequestBody Billing billing) {

		return null;
	}

	/**
	 * 
	 * @param Id
	 * @return
	 */
	@DeleteMapping("/bID")
	public ResponseEntity<Void> deleteBillingById(@PathVariable Long Id) {
		return null;
	}

	/**
	 * 
	 * @param bId
	 * @return
	 */
	@PatchMapping("{bId}/pay")
	public ResponseEntity<String> markBillingAsPaid(@PathVariable Long bId) {
//		return billingRepository.findById(bId).map(billing -> {
//			if (billing.isPaid()) {
//				return ResponseEntity.badRequest().body("Billing record is already paid.");
//			}
//			billing.setPaid(true);
//			billing.setPaymentDate(LocalDateTime.now()); // Set payment timestamp
//			billingRepository.save(billing);
//			return ResponseEntity.ok("Billing record marked as paid.");
//		}).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Billing record not found."));

		return null;
	}

}
