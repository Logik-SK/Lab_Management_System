package com.sks.HospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sks.HospitalManagement.model.Appointment;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

}
