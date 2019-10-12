/*
package com.api.healthelp.dao;

import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.JwtUser;
import com.api.healthelp.utils.UserUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.stream.Collectors;
import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Mock
    private UserDao userDao;




    @Test
    public void t10_userDaoGetUsersAllTest(){
        List<UserDTO> userDTOList = userDao.getUsers();
        assertTrue(userDTOList.size()>0);
    }

    @Test
    public void t2_userDaoGetUsersEmptyTest(){
        List<UserDTO> userDTOList = userDao.getUsers();
        userDTOList.removeIf(item->userDTOList.contains(item));
        assertTrue(userDTOList.isEmpty());
    }

    @Test
    public void t3_userDaoGetUserPasswordAllTest(){
        String password = "healthelp";
        JwtUser userLogin = userDao.getUserByPassword(password);
        assertTrue(userLogin.getId()>0);
    }

    @Test
    public void t4_userDaoGetUserPasswordEmptyTest(){
        String password = "xxx";
        JwtUser userLogin = userDao.getUserByPassword(password);
        assertTrue(userLogin == null);
    }

    @Test
    public void t5_userDaoGetUserByIdAllTest() {
        User user = userDao.getUserById(1);
        assertTrue(user.getId() > 0);
    }

    @Test
    public void t6_userDaoGetUserByIdEmptyTest(){
        User user = userDao.getUserById(-1);
        assertTrue(user == null);
    }

    @Test
    public void t7_userDaoUpdateUserAllTest(){
        User user = UserUtils.createdummyUser();
        User userDTO = userDao.updateUser(user);
        assertTrue(userDTO.getId()>0);
    }

    @Test
    public void t8_userDaoUpdateUserEmptyTest(){
        User user = UserUtils.createdummyUser();
        user.setId(null);
        User userDTO = userDao.updateUser(user);
        assertTrue(userDTO == null);
    }

    @Test
    public void t1_userDaoInsertUserAllTest(){
        User user = UserUtils.createdummyUser();
        user.setId(6);
        user.setEmail("test@test.com");
        user.setUsername("test");
        user.setPassword("test");
        user.setProfileId(2);
        UserDTO userDTO = userDao.insertUser(user);
        assertTrue(userDTO.getId()!= null);
    }

    @Test
    public void t9_userDaoDeleteUserAllTest(){
        List<UserDTO> users = userDao.getUsers();
        users.stream().filter(item -> item.getId()>1)
                      .map(usersList->userDao.deleteUser(usersList.getId())).collect(Collectors.toList());
        assertTrue(users != null);
    }
}
*/
