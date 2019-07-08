package com.api.healthelp.service.impl;

import com.api.healthelp.dao.PatientDao;
import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao){
        this.patientDao = patientDao;
    }

    @Override
    public List<PatientDTO> getPatients() {
        return patientDao.getPatients();
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public PatientDTO getPatientByName(String patientName) {
        return patientDao.getPatientByName(patientName);
    }


}
