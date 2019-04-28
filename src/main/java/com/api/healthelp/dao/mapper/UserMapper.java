package com.api.healthelp.dao.mapper;


import com.api.healthelp.model.User;
import com.api.healthelp.model.UserLogin;
import com.api.healthelp.model.dto.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface UserMapper extends Serializable {
    List<UserDTO> getUsers();
    UserLogin getUserByPassword(@Param("password") String password);
    User getUserById(@Param("userId") Integer id);
    void updateUser(@Param("id") Integer id, @Param("username") String username, @Param("password") String password, @Param("tenantId") Integer tenant_id, @Param("profileId") Integer profile_id, @Param("email") String email);
    UserDTO getUserDTOById(Integer id);
}
