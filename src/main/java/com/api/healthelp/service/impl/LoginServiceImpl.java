package com.api.healthelp.service.impl;

import com.api.healthelp.boot.auth.AuthClaims;
import com.api.healthelp.boot.properties.Properties;
import com.api.healthelp.dao.UserDao;
import com.api.healthelp.model.UserCredentials;
import com.api.healthelp.model.security.JwtUser;
import com.api.healthelp.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
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
        logger.info("");
        JwtUser jwtUser = userDao.getUserByPassword(userCredentials.getPassword());
        logger.info(jwtUser.getEmail());
        if(jwtUser != null){
            logger.info(" -- Welcome API HEALHELP {}",jwtUser.getEmail());
            List<String> list = new ArrayList<>();
            list.add("Bearer "+authClaims.jwtGenerator(jwtUser)+" ");
            return list;
        }
        else{
            logger.info(" -- User Not Found {}",jwtUser.getEmail());
            return null;
        }
    }
}
