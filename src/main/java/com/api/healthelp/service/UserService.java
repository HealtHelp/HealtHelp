package com.api.healthelp.service;


import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.UserResponse;

import javax.naming.AuthenticationException;
import java.io.Serializable;
import java.util.List;

public interface UserService extends Serializable {
    List<UserDTO> getUsers() throws RuntimeException;
    User updateUser(User updateUser);
    User insertUser(User user);
    UserResponse authenticateUser(User user) throws AuthenticationException;
}
