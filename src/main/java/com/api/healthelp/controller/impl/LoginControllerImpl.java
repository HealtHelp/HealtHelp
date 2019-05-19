package com.api.healthelp.controller.impl;

import com.api.healthelp.controller.LoginController;
import com.api.healthelp.model.UserCredentials;
import com.api.healthelp.service.LoginService;

public class LoginControllerImpl implements LoginController {

    private LoginService loginService;

    public LoginControllerImpl(final LoginService loginService){
        this.loginService = loginService;
    }

    @Override
    public String login(UserCredentials userCredentials) {
        return loginService.login(userCredentials);
    }
}
