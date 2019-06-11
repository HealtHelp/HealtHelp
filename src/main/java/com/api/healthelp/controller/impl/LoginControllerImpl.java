package com.api.healthelp.controller.impl;

import com.api.healthelp.controller.LoginController;
import com.api.healthelp.model.security.UserCredentials;
import com.api.healthelp.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class LoginControllerImpl implements LoginController {

    private LoginService loginService;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public LoginControllerImpl(final LoginService loginService){
        this.loginService = loginService;
    }

    @Override
    public  String login(UserCredentials userCredentials) {
        logger.info(" -- POST  /login {}",userCredentials.getEmail());
        return loginService.login(userCredentials);
    }
}
