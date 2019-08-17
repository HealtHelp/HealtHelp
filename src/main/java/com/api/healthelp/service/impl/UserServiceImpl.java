package com.api.healthelp.service.impl;


import com.api.healthelp.dao.UserDao;
import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.JwtUser;
import com.api.healthelp.model.security.UserResponse;
import com.api.healthelp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.naming.AuthenticationException;
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
    public User updateUser(User updateUser) {
        User principal = userDao.getUserById(updateUser.getId());
        boolean check = BCrypt.checkpw(principal.getPassword(),BCrypt.hashpw (principal.getPassword() , BCrypt.gensalt (12)));
        String securedPassword = BCrypt.hashpw (principal.getPassword() , BCrypt.gensalt (12));
        logger.info("Secured password created: {}",securedPassword);
        if(check){
            logger.info(" -- Update user: {} ok",updateUser.getUsername());
            return userDao.updateUser(updateUser);
        }
        else{
            return null;
        }
    }

    @Override
    public User insertUser(User user) {
        JwtUser userValidate = userDao.getUserByEmail(user.getEmail());
        if(userValidate == null){
            return userDao.insertUser(user);
        }
        else{
            return null;
        }
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User getUserIdByEmail(String email) {
        return userDao. getUserIdByEmail(email);
    }

    @Override
    public UserResponse authenticateUser(User user) throws AuthenticationException {
        JwtUser existingUser;
        try{
            existingUser = userDao.getUserByPassword(user.getPassword());
        }catch(Exception ex){
            throw new RuntimeException("Authenticateuser"+ex.toString());
        }
        if(existingUser!=null && BCrypt.checkpw(user.getPassword(), existingUser.getPassword())){
            //return existingUser;
            return null;
        }else{
            //throw new Exception();
            return new UserResponse();
        }
    }


}
