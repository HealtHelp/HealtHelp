package com.api.healthelp.controller;


import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.UserCredentials;
import io.swagger.annotations.*;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = { "Login" }, description = "Access API management resource")
@ExposesResourceFor(User.class)
@RestController
public interface LoginController {

    @ApiOperation(value="Insert credentials ",notes="Insert login credentials.")
    @PostMapping(path="/login", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    ResponseEntity<String> login(@ApiParam(name="User credentials", value="User credentials",required = true)@RequestBody UserCredentials userCredentials);
}
