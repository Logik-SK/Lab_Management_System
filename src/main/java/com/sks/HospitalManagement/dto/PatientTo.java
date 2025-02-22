package com.sks.HospitalManagement.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sks.HospitalManagement.model.Appointment;

public class PatientTo {

	private String name;
	private int age;
	private String status;
	private String department;
	private String address;
	private String gender;
	private Date admissionDate;
	private Date dischargeDate;
	private Long contact;
	private List<Appointment> appointmentList;

	public PatientTo(String name, int age, String status, String department, String address, String gender,
			Date admissionDate, Date dischargeDate, Long contact, List<Appointment> appointmentList) {
		super();
		this.name = name;
		this.age = age;
		this.status = status;
		this.department = department;
		this.address = address;
		this.gender = gender;
		this.admissionDate = admissionDate;
		this.dischargeDate = dischargeDate;
		this.contact = contact;
		this.appointmentList = appointmentList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public void addAppointment(Appointment appointment) {
		Optional.ofNullable(appointmentList).orElseGet(() -> {
			appointmentList = new ArrayList<>();
			return appointmentList;
		}).add(appointment);

	}

}
