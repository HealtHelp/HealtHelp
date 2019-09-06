package com.api.healthelp.controller.impl;

import com.api.healthelp.controller.LoginController;
import com.api.healthelp.model.security.UserCredentials;
import com.api.healthelp.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class LoginControllerImpl implements LoginController {

    private LoginService loginService;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public LoginControllerImpl(final LoginService loginService){
        this.loginService = loginService;
    }


    @Override
    public ResponseEntity<String> login(UserCredentials userCredentials) {
        logger.info(" -- POST  /login {}",userCredentials.getEmail());
        return new ResponseEntity<>(loginService.login(userCredentials), HttpStatus.OK);
    }
}
