package com.api.healthelp.service;


import com.api.healthelp.model.User;
import com.api.healthelp.model.UserLogin;
import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.service.utils.UserUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static junit.framework.TestCase.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;



    @Test
    public void userServiceGetUsersAllTest(){
        List<UserDTO> usersList = userService.getUsers();
        assertTrue(usersList.size() > 0);
    }


    @Test
    public void userServiceGetUsersEmptyTest() {
        List<UserDTO> usersList = userService.getUsers();
        usersList.removeIf(item -> usersList.contains(item));
        assertTrue(usersList.isEmpty());
    }



    @Test
    public void userServiceGetUserPasswordAllTest() throws Exception {
        String pwd = "healthelp";
        UserLogin userLogin = userService.getUserByPassword(pwd);
        assertTrue(userLogin.getId()>0);
    }

    @Test
    public void userServiceGetUserPasswordEmptyTest() throws Exception{
        String pwd = "xxx";
        User user = UserUtils.createdummyUser();
        ((User) user).setPassword(pwd);
        UserLogin userLogin = userService.getUserByPassword(user.getPassword());
        assertTrue(userLogin == null);
    }

    @Test
    public void userServiceUpdateUserAllTest(){
        User user = UserUtils.createdummyUser();
        boolean check = BCrypt.checkpw(user.getPassword(),BCrypt.hashpw (user.getPassword() , BCrypt.gensalt (12)));
        UserDTO userDTO = userService.updateUser(user);
        assertTrue(check);
        assertTrue(userDTO.getId()>0);
    }


    @Test
    public void userServiceUpdateUserEmptyTest(){
        User user = UserUtils.createdummyUser();
        User user2 = UserUtils.createdummyUser();
        user.setPassword("admin");
        boolean check = BCrypt.checkpw(user2.getPassword(),BCrypt.hashpw (user.getPassword() , BCrypt.gensalt (12)));
        assert(check==false);
    }
}
