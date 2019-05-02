package com.api.healthelp.service.impl;


import com.api.healthelp.dao.UserDao;
import com.api.healthelp.model.User;
import com.api.healthelp.model.UserLogin;
import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;

    }

    @Override
    public List<UserDTO> getUsers() throws RuntimeException {
        return userDao.getUsers();
    }

    @Override
    public UserLogin getUserByPassword(String password) throws Exception {
        return userDao.getUserByPassword(password);
    }

    @Override
    public UserDTO updateUser(User updateUser) {
        User principal = userDao.getUserById(updateUser.getId());
        boolean check = BCrypt.checkpw(principal.getPassword(),BCrypt.hashpw (principal.getPassword() , BCrypt.gensalt (12)));
        String securedPassword = BCrypt.hashpw (principal.getPassword() , BCrypt.gensalt (12));
        logger.info("Secured password created: {}",securedPassword);
        if(check){
            logger.info(" -- Update user: {} ok",updateUser.getUsername());
            //userDao.insertGroups()
            //userDao.insertUserGroup(updateUser.getId(),updateUser.getProfileId())
            return userDao.updateUser(updateUser);
        }
        else{
            return null;
        }
    }
}
