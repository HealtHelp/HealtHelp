package com.api.healthelp.service;


import com.api.healthelp.model.User;
import com.api.healthelp.model.UserLogin;
import com.api.healthelp.model.dto.UserDTO;
import java.io.Serializable;
import java.util.List;

public interface UserService extends Serializable {
    List<UserDTO> getUsers() throws RuntimeException;
    UserLogin getUserByPassword(String password) throws Exception;
    UserDTO updateUser(User updateUser);
}
