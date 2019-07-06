package com.api.healthelp.service;

import com.api.healthelp.model.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    List<PatientDTO> getPatients();
    PatientDTO getPatientId(Long id);
}
