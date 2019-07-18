package com.api.healthelp.service;

import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.entity.Patient;

import java.util.List;

public interface PatientService {
    List<PatientDTO> getPatients();
    PatientDTO getPatientById(Long id);
    PatientDTO getPatientByName(String patientName);
    PatientDTO insertPatient(Patient patient);
    PatientDTO updatePatient(Patient patient);
}
