package com.sks.HospitalManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sks.HospitalManagement.dto.AppointmentTo;
import com.sks.HospitalManagement.mapper.Mapper;
import com.sks.HospitalManagement.model.Appointment;
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

	public List<AppointmentTo> getAllAppointments() {
		List<Appointment> appointmentList = appointmentRepository.findAll();
		return appointmentList.stream().map(appointment -> Mapper.toDto(Optional.of(appointment)))
				.collect(Collectors.toList());

	}

	public Appointment addAppointment(AppointmentTo appointmentTo) {
		// Doctor doctor =
		// doctorRepository.findById(appointmentTo.getDoctorId()).orElseThrow();

		// check patient present in db or not
		Patient patient = patientRepository.findById(appointmentTo.getPatientId()).orElseThrow();
		Appointment appointment = Mapper.toEntity(Optional.of(appointmentTo));
		appointment.setPatient(patient);
		// appointment.setDoctor(doctor);
		return appointmentRepository.save(appointment);
	}

	public Optional<Appointment> findAppointmentById(Long aID) {
		return appointmentRepository.findById(aID);

	}

}
