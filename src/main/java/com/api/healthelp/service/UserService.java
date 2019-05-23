package com.api.healthelp.service;


import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;

import java.io.Serializable;
import java.util.List;

public interface UserService extends Serializable {
    List<UserDTO> getUsers() throws RuntimeException;
    UserDTO updateUser(User updateUser);
    UserDTO insertUser(User user);
}
