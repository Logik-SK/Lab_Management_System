package com.sks.HospitalManagement.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.sks.HospitalManagement.model.Doctor;
import com.sks.HospitalManagement.model.Patient;

public class AppointmentTo {

	private String patientname;
	private LocalDateTime appointmentDate;
	private Long patientId;
	private Long doctorId;
	private Patient patient;
	private Doctor doctor;
	
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public AppointmentTo(LocalDateTime appointmentDate, Patient patient, Doctor doctor) {
		super();
		this.appointmentDate = appointmentDate;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	

}
