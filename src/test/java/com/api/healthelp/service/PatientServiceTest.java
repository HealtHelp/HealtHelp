package com.api.healthelp.service;

import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.entity.Patient;
import com.api.healthelp.utils.PatientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void patientServiceGetPatientsAllTest(){
        List<PatientDTO> patientList = patientService.getPatients();
        assertTrue(patientList.size()>0);
    }

    @Test
    public void patientServiceGetPatientsEmptyTest(){
        List<PatientDTO> patientList = patientService.getPatients();
        patientList.removeIf(patient->patientList.contains(patient));
        assertTrue(patientList.isEmpty());
    }

    @Test
    public void patientServiceGetPatientIdAllTest(){
        Long patientId = new Long(1);
        PatientDTO patient = patientService.getPatientById(patientId);
        assertTrue(patient!=null);
    }

    @Test
    public void patientServiceGetPatientNameAllTest(){
        Patient patient = PatientUtils.createdummyPatient();
        PatientDTO patientDTO = patientService.getPatientByName(patient.getPatientName());
        assertTrue(patientDTO != null);

    }

    @Test
    public void patientServiceGetPatientNameEmptyTest(){
        PatientDTO patientDTO = patientService.getPatientByName("test");
        assertTrue(patientDTO == null);
    }

    @Test
    public void patientServicePOSTPatientAllTest(){
        Patient patient = PatientUtils.createdummyPatientPOSTService2();
        PatientDTO patientDTO = patientService.insertPatient(patient);
        assertTrue(patientDTO != null);
    }

    @Test
    public void patientServicePUTPatientEmptyTest(){
        Patient patient = PatientUtils.createdummyPatientPOSTService2();
        patient.setId(null);
        PatientDTO patientDTO = patientService.updatePatient(patient);
        assertTrue(patientDTO == null);
    }

    @Test
    public void patientServicePUTPatientAllTest(){
        Patient patient = PatientUtils.createdummyPatientPOSTService2();
        PatientDTO patientDTO = patientService.updatePatient(patient);
        assertTrue(patientDTO != null);
    }
}
