package com.api.healthelp.dao.mapper;

import com.api.healthelp.model.dto.PatientDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {
    List<PatientDTO> getPatients();
    PatientDTO getPatientId(@Param("patientId")Long id);
}
