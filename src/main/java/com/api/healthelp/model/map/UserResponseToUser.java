package com.api.healthelp.model.map;

import com.api.healthelp.model.entity.User;
import com.api.healthelp.model.security.UserResponse;

public class UserResponseToUser {
    private UserResponseToUser(){}
        public static User map(UserResponse userResponse){
            return new User(userResponse.getId(),userResponse.getPassword(),userResponse.getTenantId(),userResponse.getProfileId(),userResponse.getEmail());
        }
}


