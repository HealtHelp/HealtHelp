package com.api.healthelp.controller;

import com.api.healthelp.model.UserCredentials;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@Api(tags = { "Login" }, description = "Login management resource")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public interface SecurityController extends Serializable {

    @ApiOperation(value = "Login request", notes="Login request, which returns a valid token in response headers")
    @PostMapping(path="/login",consumes={MediaType.APPLICATION_JSON_VALUE},produces = { MediaType.APPLICATION_JSON_VALUE } )
    ResponseEntity<List<String>> getToken(@RequestBody UserCredentials userCredentials) throws NullPointerException;
}
