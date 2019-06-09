package com.api.healthelp.service.impl;



import com.api.healthelp.dao.UserDao;
import com.api.healthelp.model.security.JwtUser;
import com.api.healthelp.model.security.UserCredentials;
import com.api.healthelp.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private UserDao userDao;


    public LoginServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public String login(UserCredentials userCredentials) {
        JwtUser jwtUser = userDao.getUserByPassword(userCredentials.getPassword());
        JwtUser jwtUser2 = userDao.getUserByEmail(userCredentials.getEmail());
        //email
        logger.info(jwtUser.getEmail());
        if(jwtUser.getEmail().equals(jwtUser2.getEmail()) && jwtUser.getPassword().equals(jwtUser2.getPassword())){
            logger.info(" -- Welcome API HEALHELP {}",jwtUser.getEmail());
            return "ok";
        }
        else{
            logger.info(" -- User Not Found {}",jwtUser.getEmail());
            return null;
        }
    }
}
