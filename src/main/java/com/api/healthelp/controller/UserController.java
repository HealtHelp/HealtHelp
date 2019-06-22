package com.api.healthelp.controller;

import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import io.swagger.annotations.*;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Api(tags = { "User" }, description = "User management resource")
@RestController
@ExposesResourceFor(User.class)
public interface  UserController {



    @ApiOperation(value = "Get users", notes="Get users request. Enter Bearer and space after the token")
    @GetMapping(path="/api/users",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resources<UserDTO>> getUsers()throws RuntimeException;


    @ApiOperation(value="Update user password",notes="Update user request. Enter Bearer and space after the token")
    @PutMapping(path="/api/user", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<User>> updateUser(@ApiParam(name="User password", value="User password")@RequestBody User updateUser);


    @ApiOperation(value="Insert user ",notes="Insert user request. Enter Bearer and space after the token")
    @PostMapping(path="/api/user", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<User> insertUser(@ApiParam(name="User password", value="User password")@RequestBody User user);





}
