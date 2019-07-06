package com.api.healthelp.dao.impl;

import com.api.healthelp.dao.PatientDao;
import com.api.healthelp.dao.mapper.PatientMapper;
import com.api.healthelp.model.dto.PatientDTO;

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
    public PatientDTO getPatientId(Long id) {
        return patientMapper.getPatientId(id);
    }
}
