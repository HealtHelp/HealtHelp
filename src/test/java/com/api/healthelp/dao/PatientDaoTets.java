package com.api.healthelp.dao;

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
public class PatientDaoTets {

    @Autowired
    private PatientDao patientDao;

    @Test
    public void patientDaoGetPatientsAllTest(){
        List<PatientDTO> patientList = patientDao.getPatients();
        assertTrue(patientList.size()>0);
    }

    @Test
    public void patientDaoGetPatientsEmptyTest(){
        List<PatientDTO> patientList = patientDao.getPatients();
        patientList.removeIf(patient->patientList.contains(patient));
        assertTrue(patientList.isEmpty());
    }


    @Test
    public void patientDaoGetPatientIdAllTest(){
        Long patientId = new Long(1);
        PatientDTO patient = patientDao.getPatientById(patientId);
        assertTrue(patient!=null);
    }

    @Test
    public void patientDaoGetPatientIdEmptyTest(){
        Long patientId = new Long(-1);
        PatientDTO patient = patientDao.getPatientById(patientId);
        assertTrue(patient==null);
    }

    @Test
    public void patientDaoGetPatientNameAllTest(){
         Patient patient = PatientUtils.createdummyPatient();
         PatientDTO patientDTO = patientDao.getPatientByName(patient.getPatientName());
         assertTrue(patientDTO != null);
    }

    @Test
    public void patientDaoGetPatientNameEmptyTest(){
        PatientDTO patientDTO = patientDao.getPatientByName("test");
        assertTrue(patientDTO == null);
    }

    @Test
    public void patientDaoPOSTPatientAllTest(){
        Patient patient = PatientUtils.createdummyPatientPOSTService();
        PatientDTO patientDTO = patientDao.insertPatient(patient);
        assertTrue(patientDTO != null);
    }

    @Test
    public void patientDaoPUTPatientAllTest(){
        Patient patient = PatientUtils.createdummyPatient();
        PatientDTO patientDTO = patientDao.updatePatient(patient);
        assertTrue(patientDTO != null);
    }

    @Test
    public void patientDaoPUTPatientEmptyTest(){
        Patient patient = PatientUtils.createdummyPatient();
        patient.setId(null);
        PatientDTO patientDTO = patientDao.updatePatient(patient);
        assertTrue(patientDTO == null);
    }
}
