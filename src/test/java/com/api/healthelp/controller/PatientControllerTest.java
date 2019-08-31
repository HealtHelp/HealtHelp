package com.api.healthelp.controller;


import com.api.healthelp.utils.PatientUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void patientControllerGETPatientsAll() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/patients"));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void patientControllerGETPatientByIdAll() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/patient/1").contentType(MediaType.APPLICATION_JSON));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void patientControllerPOSTPatientAll() throws Exception {
        String patient = PatientUtils.createdummyPatientPOSTJSON();
        ResultActions resultActions = mockMvc.perform(post("/api/patient").contentType(MediaType.APPLICATION_JSON).content(patient));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.patientName").value("Rodolfo Test"));
    }

    @Test
    public void patientControllerPUTPatientAll() throws Exception {
        String patient = PatientUtils.createdummyPatientPUTJSON();
        ResultActions resultActions = mockMvc.perform(put("/api/patient").contentType(MediaType.APPLICATION_JSON).content(patient));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.patientName").value("Manuel Test"));
    }

    @Test
    public void patientControllerGETPatientsByNameAll() throws Exception {
        String patientName = PatientUtils.createdummyPatientName();
        String userId = PatientUtils.createdummyUserId();
        ResultActions resultActions = mockMvc.perform(get("/api/patient/name/"+patientName+"/userId/"+userId));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void patientControllerDELETEPatientEmptyTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/api/patient/{id}","x"));
        resultActions.andDo(print());
        resultActions.andExpect(status().is(400));
    }


    @Test
    public void patientControllerDELETEUserAllTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/api/patient/2").contentType(MediaType.APPLICATION_JSON));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk());
    }
}
