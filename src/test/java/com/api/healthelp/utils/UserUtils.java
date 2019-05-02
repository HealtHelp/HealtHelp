package com.api.healthelp.utils;

import com.api.healthelp.model.User;
import com.api.healthelp.model.UserCredentials;
import com.api.healthelp.model.UserLogin;
import com.api.healthelp.model.dto.UserDTO;

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

    public static UserCredentials createdummyUserCredentials(){
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setPassword("admin");
        userCredentials.setUsername("admin");
        return userCredentials;
    }

    public static UserLogin createdummyUserLogin(){
        UserLogin userLogin = new UserLogin();
        userLogin.setId(1);
        userLogin.setPassword("admin");
        userLogin.setRole("ADMIN");
        return userLogin;
    }
}
