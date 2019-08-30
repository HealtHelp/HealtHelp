package com.api.healthelp.dao.impl;


import com.api.healthelp.dao.UserDao;
import com.api.healthelp.dao.mapper.UserMapper;
import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.dto.UserKeyValueDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.JwtUser;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private UserMapper userMapper;

    public UserDaoImpl(UserMapper userMapper){
        this.userMapper=userMapper;


    }

    @Override
    public List<UserDTO> getUsers() throws RuntimeException {
        return userMapper.getUsers();
    }

    @Override
    public JwtUser getUserByPassword(String password) throws NullPointerException {
        return userMapper.getUserByPassword(password);
    }


    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User updateUser(User updateUser) {
        userMapper.updateUser(updateUser.getId(),updateUser.getUsername(),updateUser.getPassword(),updateUser.getTenantId(),updateUser.getProfileId(),updateUser.getEmail());
        return userMapper.getUserById(updateUser.getId());
    }

    @Override
    public User insertUser(User user) {
        userMapper.insertUser(user.getId(),user.getUsername(),user.getPassword(),user.getTenantId(),user.getProfileId(),user.getEmail());
        return userMapper.getUserById(user.getId());
    }

    @Override
    public Boolean deleteUser(Long id) {
       return userMapper.deleteUser(id);
    }

    @Override
    public List<JwtUser> getUsersRoles() {
        return userMapper.getUsersRoles();
    }

    @Override
    public JwtUser getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public UserKeyValueDTO getUserIdByEmail(String email) {
        return userMapper.getUserIdByEmail(email);
    }


}
