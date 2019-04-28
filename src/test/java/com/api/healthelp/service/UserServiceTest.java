package com.api.healthelp.service;


import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.service.utils.UserUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserService userService;


    @Test
    public void userServiceMockGetUsersEmpty() {
        List<UserDTO> users = new ArrayList<>();
        when(userService.getUsers()).thenReturn(users);
        List<UserDTO> usersList = userService.getUsers();
        assertTrue(usersList.isEmpty());
    }

    @Test
    public void userServiceMockGetUsersAll(){
        List<UserDTO> users = UserUtils.createdummyUserDTOList();
        when(userService.getUsers()).thenReturn(users);
        List<UserDTO> usersList = userService.getUsers();
        assertTrue(usersList.size() > 0);
    }
}
