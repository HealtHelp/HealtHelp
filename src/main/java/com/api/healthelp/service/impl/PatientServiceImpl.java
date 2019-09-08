package com.api.healthelp.service.impl;

import com.api.healthelp.dao.PatientDao;
import com.api.healthelp.model.dto.MAXIdDTO;
import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.dto.PatientListDTO;
import com.api.healthelp.model.entity.Patient;
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
    public PatientDTO getPatientById(Integer id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public List<PatientDTO> getPatientsByName(String patientName,Integer userId) {
        return patientDao.getPatientsByName(patientName,userId);
    }

    @Override
    public PatientDTO insertPatient(Patient patient) {
        return patientDao.insertPatient(patient);
    }

    @Override
    public PatientDTO updatePatient(Patient patient) {
        return patientDao.updatePatient(patient);
    }

    @Override
    public Boolean deletePatient(Integer id) {
        return patientDao.deletePatient(id);
    }

    @Override
    public MAXIdDTO getMaxPatientId() {
        return patientDao.getMaxPatientId();
    }


}
