package com.api.healthelp.service;

import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.dto.PatientListDTO;
import com.api.healthelp.model.entity.Patient;

import java.util.List;

public interface PatientService {
    List<PatientDTO> getPatients();
    PatientDTO getPatientById(Long id);
    List<PatientDTO> getPatientsByName(String patientName,Long userId);
    PatientDTO insertPatient(Patient patient);
    PatientDTO updatePatient(Patient patient);
}
