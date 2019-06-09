package com.api.healthelp.controller;


import com.api.healthelp.model.security.UserCredentials;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "Login" }, description = "Access API management resource")
@CrossOrigin(origins = "http://localhost:3001", maxAge = 3600)
@RestController
public interface LoginController {

    @ApiOperation(value="Insert credentials ",notes="Insert login credentials.")
    @PostMapping(path="/login", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    boolean login(@ApiParam(name="User credentials", value="User credentials")@RequestBody UserCredentials userCredentials);
}
