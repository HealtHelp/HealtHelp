package com.api.healthelp.dao;



import com.api.healthelp.model.dto.MAXIdDTO;
import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.dto.UserKeyValueDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.JwtUser;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends Serializable {
    List<UserDTO> getUsers() throws RuntimeException;
    JwtUser getUserByPassword(String password) throws NullPointerException;
    User getUserById(Integer id);
    User updateUser(User updateUser);
    UserDTO insertUser(User user);
    Boolean deleteUser(Integer id);
    List<JwtUser> getUsersRoles();
    JwtUser getUserByEmail(String email);
    UserKeyValueDTO getUserIdByEmail(String email);
    MAXIdDTO getMaxUserId();

}

