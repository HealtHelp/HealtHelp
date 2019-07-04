package com.api.healthelp.service;


import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.utils.UserUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;



    @Test
    public void t1_userServiceGetUsersAllTest(){
        List<UserDTO> usersList = userService.getUsers();
        assertTrue(usersList.size() > 0);
    }


    @Test
    public void t2_userServiceGetUsersEmptyTest() {
        List<UserDTO> usersList = userService.getUsers();
        usersList.removeIf(item -> usersList.contains(item));
        assertTrue(usersList.isEmpty());
    }



    @Test
    public void t3_userServiceUpdateUserAllTest(){
        User user = UserUtils.createdummyUser();
        boolean check = BCrypt.checkpw(user.getPassword(),BCrypt.hashpw (user.getPassword() , BCrypt.gensalt (12)));
        User userDTO = userService.updateUser(user);
        assertTrue(check);
        assertTrue(userDTO.getId()>0);
    }


    @Test
    public void t4_userServiceUpdateUserEmptyTest(){
        User user = UserUtils.createdummyUser();
        User user2 = UserUtils.createdummyUser();
        user.setPassword("admin");
        boolean check = BCrypt.checkpw(user2.getPassword(),BCrypt.hashpw (user.getPassword() , BCrypt.gensalt (12)));
        assert(!check);
    }

    @Test
    public void t5_userServiceInsertUserAllTest(){
        Long id = new Long(7);
        User user = UserUtils.createdummyUser();
        user.setId(id);
        User userDTO = userService.insertUser(user);
        assertTrue(userDTO!=null);
    }


    @Test
    public void t6_userServiceDeleteUserEmptyTest(){
        Long id = new Long(-1);
        Boolean check = userService.deleteUser(id);
        assertTrue(!check);
    }

    @Test
    public void t7_userDaoDeleteUserAllTest(){
        List<UserDTO> users = userService.getUsers();
        users.stream().filter(item -> item.getId()>1)
                .map(usersList->userService.deleteUser(usersList.getId())).collect(Collectors.toList());
        assertTrue(users != null);
    }
}
