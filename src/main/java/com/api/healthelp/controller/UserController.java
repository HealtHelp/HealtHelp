package com.api.healthelp.controller;

import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.dto.UserKeyValueDTO;
import com.api.healthelp.model.dto.UserMAXIdDTO;
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



    @ApiOperation(value = "Get users", notes="Get users request.")
    @GetMapping(path="/api/users",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resources<UserDTO>> getUsers()throws RuntimeException;

    @ApiOperation(value = "Get userId by email", notes="Get users request.")
    @GetMapping(path="/api/user/email/{email}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<UserKeyValueDTO>> getUserIdByEmail(@ApiParam(name="User email request", value="User email",required = true)@PathVariable("email") String email)throws RuntimeException;



    @ApiOperation(value = "Get max userId", notes="Get users request.")
    @GetMapping(path="/api/user/lastUserId",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<UserMAXIdDTO>> getMaxUserId()throws RuntimeException;







    @ApiOperation(value="Update user password",notes="Update user request.")
    @PutMapping(path="/api/user", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<User>> updateUser(@ApiParam(name="User request", value="User request",required = true)@RequestBody User updateUser);


    @ApiOperation(value="Insert user ",notes="Insert user request.")
    @PostMapping(path="/api/user", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<User>> insertUser(@ApiParam(name="User request", value="User request",required = true)@RequestBody User user);


    @ApiOperation(value="Delete user",notes="Delete user request.")
    @DeleteMapping(path="/api/user/{id}",produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.ALL_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header")})
    ResponseEntity<Resource<Boolean>> deleteUser(@ApiParam(name="User id request", value="User id", required = true)@PathVariable("id") Integer id);





}
