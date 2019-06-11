package com.api.healthelp.utils;

import com.api.healthelp.model.entity.User;

public class UserUtils {


    public static User createdummyUser(){
        User user = new User();
        Long id = new Long(1);
        user.setId(id);
        user.setUsername("admin");
        user.setEmail("admin@admin.com");
        user.setPassword("healthelp");
        user.setProfileId(1);
        user.setTenantId(1);
        return user;
    }

    public static String createdummyUserString(){
        String  user = "{\n" +
                "\t\"id\":1,\n" +
                "\t\"username\":\"admin\",\n" +
                "\t\"password\":\"healthelp\",\n" +
                "\t\"tenantId\":1,\n" +
                "\t\"profileId\":1,\n" +
                "\t\"email\":\"admin@admin.com\"\n" +
                "}";
        return user;
    }

    public static String createdummyUserStringEmple1(){
        String  user = "{\n" +
                "\t\"id\":2,\n" +
                "\t\"username\":\"emple1\",\n" +
                "\t\"password\":\"emple1\",\n" +
                "\t\"tenantId\":1,\n" +
                "\t\"profileId\":2,\n" +
                "\t\"email\":\"emple1@emple1.com\"\n" +
                "}";
        return user;
    }

}
