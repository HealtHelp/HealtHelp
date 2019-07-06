package com.api.healthelp.service;

import com.api.healthelp.model.dto.PatientDTO;
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
    public void patientDaoGetPatientsAllTest(){
        List<PatientDTO> patientList = patientService.getPatients();
        assertTrue(patientList.size()>0);
    }

    @Test
    public void patientDaoGetPatientsEmptyTest(){
        List<PatientDTO> patientList = patientService.getPatients();
        patientList.removeIf(patient->patientList.contains(patient));
        assertTrue(patientList.isEmpty());
    }

    @Test
    public void patientDaoGetPatientIdAllTest(){
        Long patientId = new Long(1);
        PatientDTO patient = patientService.getPatientId(patientId);
        assertTrue(patient!=null);
    }
}
