package com.api.healthelp.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private Long userId;
    private Long tenantId;
    private String patientName;
    private String patientLastName;
    private String patientDni;
    private String patientTelephone;
    private String patientAddress;
    private String patientLocation;
    private String patientProfession;
    private String patientEmail;
}
