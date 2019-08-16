package com.api.healthelp.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PatientListDTO {
    List<PatientDTO> patients;
}
