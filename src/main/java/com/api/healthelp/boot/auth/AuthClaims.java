package com.api.healthelp.boot.auth;

import com.api.healthelp.boot.properties.Properties;
import com.api.healthelp.model.security.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class AuthClaims {

    private Properties properties;

    public AuthClaims(Properties properties){
        this.properties = properties;
    }

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try{
            Claims claims = (Claims) Jwts.parser()
                    .setSigningKey(properties.getBitSecret())
                    .parse(token)
                    .getBody();
            jwtUser = new JwtUser();
            jwtUser.setEmail(claims.getSubject());
            jwtUser.setId(Long.parseLong((String) claims.get(properties.getId())));
            jwtUser.setRole((String) claims.get(properties.getRole()));
            claims.getSubject();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return jwtUser;
    }

    public String jwtGenerator(JwtUser jwtUser){
        try{
            Claims claims = Jwts.claims()
                    .setSubject(jwtUser.getEmail());
            claims.put(properties.getId(),String.valueOf(jwtUser.getId()));
            claims.put(properties.getRole(),jwtUser.getRole());
            return Jwts.builder()
                    .setClaims(claims)
                    .signWith(SignatureAlgorithm.HS512,properties.getBitSecret())
                    .compact();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
