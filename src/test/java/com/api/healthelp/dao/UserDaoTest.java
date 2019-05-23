package com.api.healthelp.dao;

import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.utils.UserUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void userDaoGetUsersAllTest(){
        List<UserDTO> userDTOList = userDao.getUsers();
        assertTrue(userDTOList.size()>0);
    }

    @Test
    public void userDaoGetUsersEmptyTest(){
        List<UserDTO> userDTOList = userDao.getUsers();
        userDTOList.removeIf(item->userDTOList.contains(item));
        assertTrue(userDTOList.isEmpty());
    }
/*
    @Test
    public void userDaoGetUserPasswordAllTest(){
        String password = "healthelp";
        JwtUser userLogin = userDao.getUserByPassword(password);
        assertTrue(userLogin.getId()>0);
    }

    @Test
    public void userDaoGetUserPasswordEmptyTest(){
        String password = "xxx";
        JwtUser userLogin = userDao.getUserByPassword(password);
        assertTrue(userLogin == null);
    }*/

    @Test
    public void userDaoGetUserByIdAllTest() {
        Integer id = 1;
        User user = userDao.getUserById(id);
        assertTrue(user.getId() > 0);
    }

    @Test
    public void userDaoGetUserByIdEmptyTest(){
        Integer id = -1;
        User user = userDao.getUserById(id);
        assertTrue(user == null);
    }

    @Test
    public void userDaoUpdateUserAllTest(){
        User user = UserUtils.createdummyUser();
        UserDTO userDTO = userDao.updateUser(user);
        assertTrue(userDTO.getId()>0);
    }

    @Test
    public void userDaoUpdateUserEmptyTest(){
        User user = UserUtils.createdummyUser();
        user.setId(null);
        UserDTO userDTO = userDao.updateUser(user);
        assertTrue(userDTO == null);
    }

    @Test
    public void userDaoInsertUserAllTest(){
        User user = UserUtils.createdummyUser();
        Random rm = new Random();
        user.setId(rm.nextInt());
        user.setUsername("test");
        user.setPassword("test");
        user.setProfileId(2);
        UserDTO userDTO = userDao.insertUser(user);
        assertTrue(userDTO.getId()!= null);
    }


}
