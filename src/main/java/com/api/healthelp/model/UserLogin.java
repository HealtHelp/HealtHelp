package com.api.healthelp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String role;
}
