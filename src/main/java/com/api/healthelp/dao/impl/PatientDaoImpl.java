package com.api.healthelp.dao.impl;

import com.api.healthelp.dao.PatientDao;
import com.api.healthelp.dao.mapper.PatientMapper;
import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.dto.PatientListDTO;
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
    public PatientDTO getPatientById(Integer id) {
        return patientMapper.getPatientById(id);
    }

    @Override
    public List<PatientDTO> getPatientsByName(String patientName,Integer userId) {
        return patientMapper.getPatientsByName(patientName,userId);
    }

    @Override
    public PatientDTO insertPatient(Patient patient) {
         patientMapper.insertPatient(patient.getId(),patient.getUserId(),patient.getTenantId(),patient.getPatientName(),
                                           patient.getPatientLastName(),patient.getPatientDNI(),
                                           patient.getPatientTelephone(),patient.getPatientAddress(),patient.getPatientLocation(),
                                           patient.getPatientProfession(),patient.getPatientEmail());
         return patientMapper.getPatientById(patient.getId());
    }

    @Override
    public PatientDTO updatePatient(Patient patient) {
        patientMapper.updatePatient(patient.getId(),patient.getUserId(),patient.getTenantId(),patient.getPatientName(),
                                    patient.getPatientLastName(),patient.getPatientDNI(),
                                    patient.getPatientTelephone(),patient.getPatientAddress(),patient.getPatientLocation(),
                                    patient.getPatientProfession(),patient.getPatientEmail());
        return patientMapper.getPatientById(patient.getId());
    }

    @Override
    public Boolean deletePatient(Integer id) {
        return patientMapper.deletePatient(id);
    }
}
