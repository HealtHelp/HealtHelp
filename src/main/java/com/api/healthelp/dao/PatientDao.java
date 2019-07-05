package com.api.healthelp.dao;

import com.api.healthelp.model.dto.PatientDTO;

import java.util.List;

public interface PatientDao {
    List<PatientDTO> getPatients();
}
