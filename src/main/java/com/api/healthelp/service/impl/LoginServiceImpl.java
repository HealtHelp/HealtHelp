package com.api.healthelp.service.impl;



import com.api.healthelp.boot.auth.AuthClaims;
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
    private AuthClaims authClaims;


    public LoginServiceImpl(UserDao userDao,AuthClaims authClaims) {
        this.userDao = userDao;
        this.authClaims = authClaims;
    }

    @Override
    public String login(UserCredentials userCredentials) {
        JwtUser jwtUser = userDao.getUserByPassword(userCredentials.getPassword());
        JwtUser jwtUser2 = userDao.getUserByEmail(userCredentials.getEmail());
        if(jwtUser.getEmail().equals(jwtUser2.getEmail()) && jwtUser.getPassword().equals(jwtUser2.getPassword())){
            logger.info(" -- Welcome API HEALHELP {}",authClaims.generate(jwtUser));
            return "Bearer "+authClaims.generate(jwtUser);
        }
        else{
            logger.info(" -- Bad Credentials {}",jwtUser.getEmail());
            return null;
        }
    }
}
