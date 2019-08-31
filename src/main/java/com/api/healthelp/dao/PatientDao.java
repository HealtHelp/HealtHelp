package com.api.healthelp.dao;

import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.dto.PatientListDTO;
import com.api.healthelp.model.entity.Patient;

import java.util.List;

public interface PatientDao {
    List<PatientDTO> getPatients();
    PatientDTO getPatientById(Integer id);
    List<PatientDTO> getPatientsByName(String patientName,Integer userId);
    PatientDTO insertPatient(Patient patient);
    PatientDTO updatePatient(Patient patient);
    Boolean deletePatient(Integer id);
}
