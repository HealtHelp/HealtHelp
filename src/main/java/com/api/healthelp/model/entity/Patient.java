package com.api.healthelp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements Serializable {
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
