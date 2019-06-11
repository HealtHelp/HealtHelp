package com.api.healthelp.model.security;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {
    private Long id;
    private String email;
    private String password;
    private Integer profileId;
    private Integer tenantId;
    private String role;

    public UserResponse(Long id,String email,String password,String role){
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
