package com.api.healthelp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;

    public JwtAuthenticationToken(String token) {
        super(null,null);
        this.token=token;
    }

    @Override
    public Object getCredentials(){
        return null;
    }


    @Override
    public Object getPrincipal(){
        return null;
    }

    //Getters
    public String getToken() {
        return token;
    }




}
