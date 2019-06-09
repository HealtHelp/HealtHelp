package com.api.healthelp.model.map;

import com.api.healthelp.model.security.JwtUser;
import com.api.healthelp.model.security.UserResponse;

public class JwtUserToUserResponse {
    private JwtUserToUserResponse(){}
        public static UserResponse map(JwtUser jwtUser){
            return new UserResponse(jwtUser.getId(),jwtUser.getEmail(),jwtUser.getPassword(),jwtUser.getRole());
        }
    }

