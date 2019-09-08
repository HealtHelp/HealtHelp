package com.api.healthelp.controller.impl;


import com.api.healthelp.controller.UserController;
import com.api.healthelp.model.dto.MAXIdDTO;
import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.dto.UserKeyValueDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.lang.invoke.MethodHandles;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@ExposesResourceFor(UserDTO.class)
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public UserControllerImpl(final UserService userService){
        this.userService = userService;
    }


    @Override
    public ResponseEntity<Resources<UserDTO>> getUsers() throws RuntimeException {
        logger.info(" -- GET  /users " );
        Resources<UserDTO> resource = new Resources<>(userService.getUsers());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
        resource.add(linkTo.withRel("-- GET /users"));
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Resource<UserKeyValueDTO>> getUserIdByEmail(String email) throws RuntimeException {
        logger.info(" -- GET  /user/email/{} ",email );
        Resource<UserKeyValueDTO> resource = new Resource<>(userService.getUserIdByEmail(email));
        Link link = linkTo(UserControllerImpl.class).slash("api/user/email/"+email).withSelfRel();
        resource.add(link);
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Resource<MAXIdDTO>> getMaxUserId() throws RuntimeException {
        logger.info(" -- GET  /user/lastUserId/" );
        Resource<MAXIdDTO> resource = new Resource<>(userService.getMaxUserId());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getMaxUserId());
        resource.add(linkTo.withRel(" -- GET  /user/lastUserId/"));
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Resource<User>> updateUser(User updateUser) {
        logger.info(" -- PUT  /user {}",updateUser.getUsername());
        Resource<User> resource = new Resource<>(userService.updateUser(updateUser));
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).updateUser(updateUser));
        resource.add(linkTo.withRel("-- PUT  /user"));
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Resource<User>> insertUser(User user) {
        logger.info(" -- POST  /user {}",user.getUsername());
        Resource<User> resource = new Resource<>(userService.insertUser(user));
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).insertUser(user));
        resource.add(linkTo.withRel(" -- POST  /user"));
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Resource<Boolean>> deleteUser(Integer id) {
        logger.info(" -- DELETE  /user/{} ",id);
        Resource<Boolean> resource = new Resource<>(userService.deleteUser(id));
        Link link = linkTo(UserControllerImpl.class).slash("/api/user/"+id).withSelfRel();
        resource.add(link);
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }
}
