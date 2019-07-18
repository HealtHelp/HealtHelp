package com.api.healthelp.utils;

import com.api.healthelp.model.entity.Patient;

public class PatientUtils {

    public static Patient createdummyPatient(){
        Patient patient = new Patient();
        patient.setId((long)1);
        patient.setUserId((long)1);
        patient.setTenantId((long)1);
        patient.setPatientName("Roberto");
        patient.setPatientLastName("del Barrio");
        patient.setPatientDni("71107371L");
        patient.setPatientTelephone("625589030");
        patient.setPatientAddress("C/San Antón, 13");
        patient.setPatientLocation("Madrid");
        patient.setPatientProfession("Fisio");
        patient.setPatientEmail("roberto@gmx.es");
        return patient;
    }

    public static Patient createdummyPatientPOST(){
        Patient patient = new Patient();
        patient.setId((long)2);
        patient.setUserId((long)1);
        patient.setTenantId((long)1);
        patient.setPatientName("Bladimir");
        patient.setPatientLastName("del Barrio");
        patient.setPatientDni("71107371L");
        patient.setPatientTelephone("625589030");
        patient.setPatientAddress("C/Mar Menor, 28");
        patient.setPatientLocation("Madrid");
        patient.setPatientProfession("Development");
        patient.setPatientEmail("bladidb@gmail.com");
        return patient;
    }

    public static Patient createdummyPatientPOSTService(){
        Patient patient = new Patient();
        patient.setId((long)3);
        patient.setUserId((long)1);
        patient.setTenantId((long)1);
        patient.setPatientName("TestPost");
        patient.setPatientLastName("del Barrio");
        patient.setPatientDni("71107371L");
        patient.setPatientTelephone("625589030");
        patient.setPatientAddress("C/Mar Menor, 28");
        patient.setPatientLocation("Madrid");
        patient.setPatientProfession("Development");
        patient.setPatientEmail("bladidb@gmail.com");
        return patient;
    }

    public static Patient createdummyPatientPOSTService2(){
        Patient patient = new Patient();
        patient.setId((long)4);
        patient.setUserId((long)1);
        patient.setTenantId((long)1);
        patient.setPatientName("TestPostService");
        patient.setPatientLastName("del Barrio");
        patient.setPatientDni("71107371L");
        patient.setPatientTelephone("625589030");
        patient.setPatientAddress("C/Mar Menor, 28");
        patient.setPatientLocation("Madrid");
        patient.setPatientProfession("Development");
        patient.setPatientEmail("bladidb@gmail.com");
        return patient;
    }

    public static String createdummyPatientPOSTJSON(){
        String patient = "{\n" +
                "\t\"id\":2,\n" +
                "\t\"userId\":1,\n" +
                "\t\"tenantId\":1,\n" +
                "\t\"patientName\":\"testPatientName\",\n" +
                "\t\"patientLastName\":\"testPatientLastName\",\n" +
                "\t\"patientDni\":\"71107371L\",\n" +
                "\t\"patientTelephone\":\"625589030\",\n" +
                "\t\"patientAddress\":\"C/test,34\",\n" +
                "\t\"patientLocation\":\"Madrid\",\n" +
                "\t\"patientProfession\":\"development\",\n" +
                "\t\"patientEmail\":\"test@test.com\"\n" +
                "}";
        return patient;
    }

    public static String createdummyPatientPUTJSON(){
        String patient = "{\n" +
                "\t\"id\":2,\n" +
                "\t\"userId\":1,\n" +
                "\t\"tenantId\":1,\n" +
                "\t\"patientName\":\"testUpdate\",\n" +
                "\t\"patientLastName\":\"testPatientLastName\",\n" +
                "\t\"patientDni\":\"71107371L\",\n" +
                "\t\"patientTelephone\":\"625589030\",\n" +
                "\t\"patientAddress\":\"C/test,34\",\n" +
                "\t\"patientLocation\":\"Milagros\",\n" +
                "\t\"patientProfession\":\"development\",\n" +
                "\t\"patientEmail\":\"test@test.com\"\n" +
                "}";
        return patient;
    }
}
