package com.api.healthelp.dao.mapper;


import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.JwtUser;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface UserMapper extends Serializable {
    List<UserDTO> getUsers();
    JwtUser getUserByPassword(@Param("password") String password);
    JwtUser getUserByEmail(@Param("email") String email);
    User getUserById(@Param("userId") Long id);
    Boolean deleteUser(@Param("userId") Long id);
    void updateUser(@Param("id") Long id, @Param("username") String username, @Param("password") String password, @Param("tenantId") Integer tenant_id, @Param("profileId") Integer profile_id, @Param("email") String email);
    UserDTO getUserDTOById(Long id);
    void insertUser(@Param("id") Long id, @Param("username") String username, @Param("password") String password, @Param("tenantId") Integer tenantId, @Param("profileId") Integer profileId, @Param("email") String email);
    List<JwtUser> getUsersRoles();
    User getUserIdByEmail(@Param("userEmail")String email);
}
