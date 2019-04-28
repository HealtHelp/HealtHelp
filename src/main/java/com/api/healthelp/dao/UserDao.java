package com.api.healthelp.dao;



import com.api.healthelp.model.User;
import com.api.healthelp.model.UserLogin;
import com.api.healthelp.model.dto.UserDTO;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends Serializable {
    List<UserDTO> getUsers() throws RuntimeException;
    UserLogin getUserByPassword(String password) throws NullPointerException;
    User getUserById(Integer id);
    UserDTO updateUser(User updateUser);
}
