package com.api.healthelp.dao;

import com.api.healthelp.model.dto.PatientDTO;

import java.util.List;

public interface PatientDao {
    List<PatientDTO> getPatients();
    PatientDTO getPatientById(Long id);
    PatientDTO getPatientByName(String patientName);
}
