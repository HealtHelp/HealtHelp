package com.api.healthelp.utils;

import com.api.healthelp.model.entity.Patient;

public class PatientUtils {

    public static Patient createdummyPatient(){
        Patient patient = new Patient();
        patient.setId(1);
        patient.setUserId(1);
        patient.setTenantId(1);
        patient.setPatientName("Bladimir Test");
        patient.setPatientLastName("del Barrio");
        patient.setPatientDNI("71107371L");
        patient.setPatientTelephone("625589030");
        patient.setPatientAddress("C/San Antón, 13");
        patient.setPatientLocation("Madrid");
        patient.setPatientProfession("Fisio");
        patient.setPatientEmail("roberto@gmx.es");
        return patient;
    }

    public static Patient createdummyPatientPOST(){
        Patient patient = new Patient();
        patient.setId(2);
        patient.setUserId(1);
        patient.setTenantId(1);
        patient.setPatientName("Bladimir Test");
        patient.setPatientLastName("del Barrio");
        patient.setPatientDNI("71107371L");
        patient.setPatientTelephone("625589030");
        patient.setPatientAddress("C/Mar Menor, 28");
        patient.setPatientLocation("Madrid");
        patient.setPatientProfession("Development");
        patient.setPatientEmail("bladidb@gmail.com");
        return patient;
    }

    public static Patient createdummyPatientPOSTService(){
        Patient patient = new Patient();
        patient.setId(3);
        patient.setUserId(46775);
        patient.setTenantId(1);
        patient.setPatientName("Rodrigo Test");
        patient.setPatientLastName("del Barrio");
        patient.setPatientDNI("71107371L");
        patient.setPatientTelephone("625589030");
        patient.setPatientAddress("C/Mar Menor, 28");
        patient.setPatientLocation("Madrid");
        patient.setPatientProfession("Development");
        patient.setPatientEmail("rodrigodelbarrio@gmail.com");
        return patient;
    }

    public static Patient createdummyPatientPOSTService2(){
        Patient patient = new Patient();
        patient.setId(4);
        patient.setUserId(1);
        patient.setTenantId(1);
        patient.setPatientName("Maria Test");
        patient.setPatientLastName("Pizarro");
        patient.setPatientDNI("71107371L");
        patient.setPatientTelephone("625589030");
        patient.setPatientAddress("C/El Cid, 28");
        patient.setPatientLocation("Madrid");
        patient.setPatientProfession("Maestra");
        patient.setPatientEmail("bladidb@gmail.com");
        return patient;
    }

    public static String createdummyPatientPOSTJSON(){
        String patient = "{\n" +
                "\t\"id\":2,\n" +
                "\t\"userId\":1,\n" +
                "\t\"tenantId\":46775,\n" +
                "\t\"patientName\":\"Rodolfo Test\",\n" +
                "\t\"patientLastName\":\"Rodolfo LastName\",\n" +
                "\t\"patientDNI\":\"71107371L\",\n" +
                "\t\"patientTelephone\":\"625589030\",\n" +
                "\t\"patientAddress\":\"C/test,34\",\n" +
                "\t\"patientLocation\":\"Madrid\",\n" +
                "\t\"patientProfession\":\"development\",\n" +
                "\t\"patientEmail\":\"Rodolfo@test.com\"\n" +
                "}";
        return patient;
    }

    public static String createdummyPatientPUTJSON(){
        String patient = "{\n" +
                "\t\"id\":2,\n" +
                "\t\"userId\":1,\n" +
                "\t\"tenantId\":1,\n" +
                "\t\"patientName\":\"Manuel Test\",\n" +
                "\t\"patientLastName\":\"testPatientLastName\",\n" +
                "\t\"patientDNI\":\"71107371L\",\n" +
                "\t\"patientTelephone\":\"625589030\",\n" +
                "\t\"patientAddress\":\"C/test,34\",\n" +
                "\t\"patientLocation\":\"Milagros\",\n" +
                "\t\"patientProfession\":\"development\",\n" +
                "\t\"patientEmail\":\"test@test.com\"\n" +
                "}";
        return patient;
    }

    public static String createdummyPatientName(){
        String name = "Roberto";
        return name;
    }

    public static String createdummyUserId(){
        String userId = "1";
        return userId;
    }

    public static Long createdummyUserIdLong(){
        Long userId =  new Long("1");
        return userId;
    }

    public static Integer createdummyUserIdInteger(){
        return 1;
    }
}
