package com.api.healthelp.dao;



import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.JwtUser;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends Serializable {
    List<UserDTO> getUsers() throws RuntimeException;
    JwtUser getUserByPassword(String password) throws NullPointerException;
    User getUserById(Long id);
    User updateUser(User updateUser);
    User insertUser(User user);
    Boolean deleteUser(Long id);
    List<JwtUser> getUsersRoles();
    JwtUser getUserByEmail(String email);
    User getUserIdByEmail(String email);
}

