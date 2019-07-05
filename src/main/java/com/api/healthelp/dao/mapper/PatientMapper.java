package com.api.healthelp.dao.mapper;

import com.api.healthelp.model.dto.PatientDTO;

import java.util.List;

public interface PatientMapper {
    List<PatientDTO> getPatients();
}
