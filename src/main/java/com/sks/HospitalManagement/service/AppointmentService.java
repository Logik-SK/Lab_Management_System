package com.sks.HospitalManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sks.HospitalManagement.dto.AppointmentTo;
import com.sks.HospitalManagement.model.Appointment;
import com.sks.HospitalManagement.model.Doctor;
import com.sks.HospitalManagement.model.Patient;
import com.sks.HospitalManagement.repository.IAppointmentRepository;
import com.sks.HospitalManagement.repository.IDoctorRepository;
import com.sks.HospitalManagement.repository.IPatientRepository;

@Service
public class AppointmentService {
	@Autowired
	IAppointmentRepository appointmentRepository;
	@Autowired
	IDoctorRepository doctorRepository;
	@Autowired
	IPatientRepository patientRepository;

	public List<Appointment> getAllAppointments() {

		return appointmentRepository.findAll();

	}

	public AppointmentTo addAppointment(AppointmentTo appointmentTo) {
		Doctor doctor = doctorRepository.findById(appointmentTo.getDoctorId()).orElseThrow();
		Patient patient = patientRepository.findById(appointmentTo.getPatientId()).orElseThrow();

		Appointment appointment = new Appointment();
		//appointment.setDoctor(doctor);
		//appointment.setPatient(patient);
		//appointment.setAppointmentDate(appointmentTo.getAppointmentDate());
		Optional<Appointment> addedOppointment = Optional.ofNullable(appointmentRepository.save(appointment));
		AppointmentTo addedAppointmentTo = null;
//		if (addedOppointment.isPresent()) {
//			addedAppointmentTo = new AppointmentTo(addedOppointment.get().getAppointmentDate(), patient, doctor);
//		}
		return addedAppointmentTo;
	}

	public Optional<Appointment> findAppointmentById(Long aID) {
		return appointmentRepository.findById(aID);

	}

}
