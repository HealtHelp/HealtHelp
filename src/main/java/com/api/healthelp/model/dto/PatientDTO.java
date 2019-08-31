package com.api.healthelp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Integer id;
    private Integer userId;
    private Integer tenantId;
    private String patientName;
    private String patientLastName;
    private String patientDNI;
    private String patientTelephone;
    private String patientAddress;
    private String patientLocation;
    private String patientProfession;
    private String patientEmail;
}
