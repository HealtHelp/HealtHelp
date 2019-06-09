package com.api.healthelp.boot.auth;

import com.api.healthelp.model.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class AuthFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;


    public AuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User creds = new ObjectMapper()
                    .readValue(request.getInputStream(), User.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}

/*
*   io.jsonwebtoken.Claims claims = Jwts.claims()
                .setSubject(jwtUser.getEmail());
         claims.put(properties.getId(),String.valueOf(jwtUser.getId()));
         claims.put(properties.getRole(),jwtUser.getRole());
         return Jwts.builder()
                 .setClaims(claims)
                 .signWith(SignatureAlgorithm.HS256,properties.getBitSecret())
                 .compact();
*
* */
