package com.api.healthelp.controller;

import com.api.healthelp.model.entity.User;
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

import static org.springframework.test.web.servlet.ResultMatcher.matchAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
    public void userControllerGetUsersAllTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/users"));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk())
                   .andExpect(jsonPath("$[*].userDToes").isArray())
                   .andExpect(jsonPath("$[*].userDToes[0]id").value(1))
                   .andExpect(jsonPath("$[*].userDToes[0]username").value("admin"));
    }

    @Test
    public void userControllerGetUsersEmptyTest() throws Exception {
       ResultActions resultActions = mockMvc.perform(get("/user"));
       resultActions.andDo(print());
       resultActions.andExpect(status().is(405))
               .andExpect(jsonPath("$[*].userDToes").doesNotExist());
    }


    @Test
    public void userControllerPutUserAllTest() throws Exception {
        String  user = UserUtils.createdummyUserString();
        ResultActions resultActions = mockMvc.perform(put("/user").contentType(MediaType.APPLICATION_JSON).content(user));
        resultActions.andDo(print());
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("admin"));
    }


    @Test
    public void userControllerPutUserEmptyTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(put("/user"));
        resultActions.andDo(print());
        resultActions.andExpect(status().is(415));
    }
}
