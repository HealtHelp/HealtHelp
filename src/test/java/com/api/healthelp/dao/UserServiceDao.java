package com.api.healthelp.dao;

import com.api.healthelp.model.User;
import com.api.healthelp.model.UserLogin;
import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.utils.UserUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceDao {

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

    @Test
    public void userDaoGetUserPasswordAllTest(){
        String password = "healthelp";
        UserLogin userLogin = userDao.getUserByPassword(password);
        assertTrue(userLogin.getId()>0);
    }

    @Test
    public void userDaoGetUserPasswordEmptyTest(){
        String password = "xxx";
        UserLogin userLogin = userDao.getUserByPassword(password);
        assertTrue(userLogin == null);
    }

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
        user.setId(-1);
        UserDTO userDTO = userDao.updateUser(user);
        assertTrue(userDTO == null);

    }
}