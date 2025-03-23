package com.sks.HospitalManagement.service;

import com.sks.HospitalManagement.dto.MedicalHistoryTo;
import com.sks.HospitalManagement.model.MedicalHistory;
import com.sks.HospitalManagement.repository.IMedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalHistoryService {
    @Autowired
    IMedicalHistoryRepository medicalHistoryRepository;

    public List<MedicalHistory> getAllMedicalHistory() {
        List<MedicalHistory> medicalHistoryList = medicalHistoryRepository.findAll();
        return medicalHistoryList;

    }
}
