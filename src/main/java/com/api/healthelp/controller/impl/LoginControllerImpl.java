package com.api.healthelp.controller.impl;

import com.api.healthelp.controller.LoginController;
import com.api.healthelp.model.security.UserCredentials;
import com.api.healthelp.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class LoginControllerImpl implements LoginController {

    private LoginService loginService;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public LoginControllerImpl(final LoginService loginService){
        this.loginService = loginService;
    }

    @Override
    public  ResponseEntity<Resource<String>> login(UserCredentials userCredentials) {
        logger.info(" -- POST  /login {}",userCredentials.getEmail());
        Resource<String> resource = new Resource<>(loginService.login(userCredentials));
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).login(userCredentials));
        resource.add(linkTo.withRel("login-user"));
        Link link = linkTo(LoginControllerImpl.class).slash("/login/"+userCredentials.getEmail()).withSelfRel();
        resource.add(link);
        return new ResponseEntity(resource, HttpStatus.OK);
    }
}
