package com.api.healthelp.controller;

import com.api.healthelp.utils.UserUtils;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void userControllerGETUsersAllTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/users"));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk())
                   .andExpect(jsonPath("$[*].userDToes").isArray());
                 /*  .andExpect(jsonPath("$[*].userDToes[0]id").value(1))
                   .andExpect(jsonPath("$[*].userDToes[0]username").value("admin"));*/
    }

    @Test
    public void userControllerGETUsersEmptyTest() throws Exception {
       ResultActions resultActions = mockMvc.perform(get("/api/user"));
       resultActions.andDo(print());
       resultActions.andExpect(status().is(405))
               .andExpect(jsonPath("$[*].userDToes").doesNotExist());
    }


    @Test
    public void userControllerPUTUserAllTest() throws Exception {
        String  user = UserUtils.createdummyUserString();
        ResultActions resultActions = mockMvc.perform(put("/api/user").contentType(MediaType.APPLICATION_JSON).content(user));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("admin"));
    }


    @Test
    public void userControllerPUTUserEmptyTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(put("/api/user"));
        resultActions.andDo(print());
        resultActions.andExpect(status().is(415));
    }

    @Test
    public void userControllerPOSTUserAllTest() throws Exception {
        String  user = UserUtils.createdummyUserStringEmple1();
        ResultActions resultActions = mockMvc.perform(post("/api/user").contentType(MediaType.APPLICATION_JSON).content(user));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.username").value("emple1"));
    }

    @Test
    public void userControllerPOSTUserEmptyTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/api/user"));
        resultActions.andDo(print());
        resultActions.andExpect(status().is(415));
    }
}
