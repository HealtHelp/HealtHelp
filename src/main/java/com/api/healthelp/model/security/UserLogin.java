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
public class UserLogin implements Serializable {
    private Long id;
    private String email;
    private String password;
    private String role;
}
