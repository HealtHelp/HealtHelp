package com.api.healthelp.dao.impl;

import com.api.healthelp.dao.PatientDao;
import com.api.healthelp.dao.mapper.PatientMapper;
import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.entity.Patient;

import java.util.List;

public class PatientDaoImpl implements PatientDao {

    private PatientMapper patientMapper;

    public PatientDaoImpl(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    @Override
    public List<PatientDTO> getPatients() {
        return patientMapper.getPatients();
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        return patientMapper.getPatientById(id);
    }

    @Override
    public PatientDTO getPatientByName(String patientName) {
        return patientMapper.getPatientByName(patientName);
    }

    @Override
    public PatientDTO insertPatient(Patient patient) {
         patientMapper.insertPatient(patient.getId(),patient.getUserId(),patient.getTenantId(),patient.getPatientName(),
                                           patient.getPatientLastName(),patient.getPatientDni(),
                                           patient.getPatientTelephone(),patient.getPatientAddress(),patient.getPatientLocation(),
                                           patient.getPatientProfession(),patient.getPatientEmail());
         return patientMapper.getPatientById((Long) patient.getId());
    }


}
