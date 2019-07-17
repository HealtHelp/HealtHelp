package com.api.healthelp.controller;

import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.entity.Patient;
import com.api.healthelp.utils.PatientUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void patientControllerGETPatientsAllTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/patients"));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void patientControllerGETPatientIdAllTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/patient/1").contentType(MediaType.APPLICATION_JSON));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void patientControllerPOSTPatientAllTest() throws Exception {
        String patient = PatientUtils.createdummyPatientPOSTJSON();
        ResultActions resultActions = mockMvc.perform(post("/api/patient").contentType(MediaType.APPLICATION_JSON).content(patient));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.patientName").value("testPatientName"));
    }


}
