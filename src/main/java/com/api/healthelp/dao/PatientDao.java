package com.api.healthelp.dao;

import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.dto.PatientListDTO;
import com.api.healthelp.model.entity.Patient;

import java.util.List;

public interface PatientDao {
    List<PatientDTO> getPatients();
    PatientDTO getPatientById(Long id);
    List<PatientDTO> getPatientsByName(String patientName);
    PatientDTO insertPatient(Patient patient);
    PatientDTO updatePatient(Patient patient);
}
