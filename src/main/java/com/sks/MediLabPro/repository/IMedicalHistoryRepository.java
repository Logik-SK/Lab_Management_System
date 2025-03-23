package com.sks.HospitalManagement.repository;

import com.sks.HospitalManagement.model.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
}
