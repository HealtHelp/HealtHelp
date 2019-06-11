package com.api.healthelp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Integer tenantId;
    private Integer profileId;
    private String email;


    public User(Long id, String password, Integer tenantId, Integer profileId, String email) {
        this.id = id;
        this.password = password;
        this.tenantId = tenantId;
        this.profileId = profileId;
        this.email = email;

    }
}
