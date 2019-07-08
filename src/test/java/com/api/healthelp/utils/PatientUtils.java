package com.api.healthelp.utils;

import com.api.healthelp.model.entity.Patient;

public class PatientUtils {

    public static Patient createdummyPatient(){
        Patient patient = new Patient();
        patient.setId((long)1);
        patient.setUserId((long)1);
        patient.setTenantId((long)1);
        patient.setPatientName("Bladimir");
        patient.setPatientDni("71107371L");
        patient.setPatientTelephone("625589030");
        patient.setPatientAddress("C/Mar Menor, 28");
        patient.setPatientLocation("Madrid");
        patient.setPatientProfession("Development");
        patient.setPatientEmail("bladidb@gmail.com");
        return patient;
    }
}
