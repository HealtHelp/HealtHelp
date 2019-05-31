package com.api.healthelp.utils;

import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.JwtUser;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {


    public static User createdummyUser(){
        User user = new User();
        user.setId(1);
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

    public static UserDTO createdummyUserDTO(){
        UserDTO user = new UserDTO();
        user.setId(1);
        user.setUsername("admin");
        user.setEmail("admin@admin.com");
        user.setPassword("healthelp");
        user.setProfileId(1);
        user.setTenantId(1);
        return user;
    }

    public static List<UserDTO> createdummyUserDTOList(){
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO user = new UserDTO();
        user.setId(1);
        user.setUsername("admin");
        user.setEmail("admin@admin.com");
        user.setPassword("healthelp");
        user.setProfileId(1);
        user.setTenantId(1);
        userDTOList.add(user);
        return  userDTOList;
    }

    public static List<User> createdummyListUsers(){
        List<User> users = new ArrayList<>();
        User user = createdummyUser();
        users.add(user);
        return users;
    }


    public static JwtUser createdummyUserLogin(){
        JwtUser userLogin = new JwtUser();
        Long idL = new Long(1);
        userLogin.setId(idL);
        userLogin.setPassword("admin");
        userLogin.setRole("ADMIN");
        return userLogin;
    }
}
