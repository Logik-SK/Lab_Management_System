package com.sks.HospitalManagement.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aId;

//	@JsonFormat(pattern = "yyyy-MM-dd") // ISO 8601 format (YYYY-MM-DD)
//	private LocalDateTime appointmentDate;
	
	private Double appointmentFee;
//	@JsonFormat(pattern = "hh:mm a")
//	private LocalTime time;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "dId")
//	private Doctor doctor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pId")
	@JsonBackReference
	private Patient patient;

	private String reason;
	private String status; // Scheduled, Completed, Canceled
	//private LocalDateTime createdAt;
	//private LocalDateTime updatedAt;

//	@OneToOne
//	@JoinColumn(name = "appointment_id")
//	private Appointment appointment;

	public Long getaId() {
		return aId;
	}

	public void setaId(Long aId) {
		this.aId = aId;
	}

//	public LocalDateTime getAppointmentDate() {
//		return appointmentDate;
//	}
//
//	public void setAppointmentDate(LocalDateTime appointmentDate) {
//		this.appointmentDate = appointmentDate;
//	}

	public Double getAppointmentFee() {
		return appointmentFee;
	}

	public void setAppointmentFee(Double appointmentFee) {
		this.appointmentFee = appointmentFee;
	}

//	public Doctor getDoctor() {
//		return doctor;
//	}
//
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}

//	public Patient getPatient() {
//		return patient;
//	}
//
//	public void setPatient(Patient patient) {
//		this.patient = patient;
//	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public LocalDateTime getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(LocalDateTime updatedAt) {
//		this.updatedAt = updatedAt;
//	}

//	public Appointment getAppointment() {
//		return appointment;
//	}
//
//	public void setAppointment(Appointment appointment) {
//		this.appointment = appointment;
//	}

}
