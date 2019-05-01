package com.api.healthelp.dao.impl;


import com.api.healthelp.dao.UserDao;
import com.api.healthelp.dao.mapper.UserMapper;
import com.api.healthelp.model.User;
import com.api.healthelp.model.UserLogin;
import com.api.healthelp.model.dto.UserDTO;

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
    public UserLogin getUserByPassword(String password) throws NullPointerException {
        return userMapper.getUserByPassword(password);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public UserDTO updateUser(User updateUser) {
        userMapper.updateUser(updateUser.getId(),updateUser.getUsername(),updateUser.getPassword(),updateUser.getTenantId(),updateUser.getProfileId(),updateUser.getEmail());
        return userMapper.getUserDTOById(updateUser.getId());
    }


}