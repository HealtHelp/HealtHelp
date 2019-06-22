package com.api.healthelp.controller.impl;


import com.api.healthelp.controller.UserController;
import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.lang.invoke.MethodHandles;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@ExposesResourceFor(UserDTO.class)
public class UserControllerImpl implements UserController {

    @Autowired
    private EntityLinks entityLinks;
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public UserControllerImpl(final UserService userService){
        this.userService=userService;
    }


    @Override
    public ResponseEntity<Resources<UserDTO>> getUsers() throws RuntimeException {
        logger.info(" -- GET  /users " );
        Resources<UserDTO> resources = new Resources<>(userService.getUsers());
        resources.add(this.entityLinks.linkToCollectionResource(User.class));
        return new ResponseEntity(resources,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Resource<User>> updateUser(User updateUser) {
        logger.info(" -- PUT  /user "+updateUser.getUsername());
        Resource<User> resource = new Resource<>(userService.updateUser(updateUser));
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).updateUser(updateUser));
        resource.add(linkTo.withRel("update-user"));
        return new ResponseEntity(resource,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> insertUser(User user) {
        logger.info(" -- POST  /user "+user.getUsername());
        Resource<User> resource = new Resource<>(userService.insertUser(user));
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).updateUser(user));
        resource.add(linkTo.withRel("insert-user"));
        return new ResponseEntity(resource,HttpStatus.OK);
    }



}
