package com.api.healthelp.service.impl;

import com.api.healthelp.boot.auth.AuthClaims;
import com.api.healthelp.boot.properties.Properties;
import com.api.healthelp.dao.UserDao;
import com.api.healthelp.model.UserCredentials;
import com.api.healthelp.model.security.JwtUser;
import com.api.healthelp.service.LoginService;

import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements LoginService {

    private UserDao userDao;
    private Properties properties;
    private AuthClaims authClaims;
    public LoginServiceImpl(UserDao userDao,Properties properties,AuthClaims authClaims){
        this.userDao = userDao;
        this.properties = properties;
        this.authClaims = authClaims;
    }

    @Override
    public List<String> login(UserCredentials userCredentials) {
        JwtUser jwtUser = userDao.getUserByPassword(userCredentials.getPassword());
        if(jwtUser != null){
            List<String> list = new ArrayList<>();
            list.add("Bearer "+authClaims.jwtGenerator(jwtUser));
            return list;
        }
        else{
            return null;
        }
    }
}
