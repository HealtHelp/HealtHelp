package com.api.healthelp.controller.impl;

import com.api.healthelp.controller.SecurityController;
import com.api.healthelp.dao.UserDao;
import com.api.healthelp.model.JwtUser;
import com.api.healthelp.model.UserCredentials;
import com.api.healthelp.model.UserLogin;
import com.api.healthelp.security.JwtGenerator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class SecurityControllerImpl implements SecurityController {

    private static final Log logger = LogFactory.getLog(UserControllerImpl.class);
    private JwtGenerator jwtGenerator;
    private UserDao userDao;

    public SecurityControllerImpl(JwtGenerator jwtGenerator,UserDao userDao){
        this.jwtGenerator=jwtGenerator;
        this.userDao=userDao;
    }

    @Override
    public ResponseEntity<List<String>> getToken(UserCredentials userCredentials) throws  NullPointerException {
        logger.info(" -- POST /login");

        UserLogin userLogin = userDao.getUserByPassword(userCredentials.getPassword());
        JwtUser jwtUser=new JwtUser();
        jwtUser.setId(userLogin.getId());
        jwtUser.setUsername(userLogin.getUsername());
        jwtUser.setRole(userLogin.getRole());


        if(jwtUser != null){
            List<String> list = new ArrayList<>();
            list.add("Bearer "+jwtGenerator.generate(jwtUser));
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else {
            logger.error(jwtUser.getUsername()+" -- Unauthorized");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }


    }


}
