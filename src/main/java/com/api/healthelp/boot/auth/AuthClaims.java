package com.api.healthelp.boot.auth;

import com.api.healthelp.boot.properties.Properties;
import com.api.healthelp.model.security.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.util.Date;

public class AuthClaims {

    private Properties properties;

    public AuthClaims(Properties properties){
        this.properties = properties;
    }

    public String generate(JwtUser jwtUser){
        try{
            Claims claims = Jwts.claims()
                    .setSubject(jwtUser.getEmail());
            claims.put(properties.getId(),String.valueOf(jwtUser.getId()));
            claims.put(properties.getRole(),jwtUser.getRole());
            return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(Date.from(Instant.now().plusSeconds(3600L)))
                    .signWith(SignatureAlgorithm.HS256,properties.getBitSecret())
                    .compact();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(properties.getBitSecret())
                    .parseClaimsJws(token)
                    .getBody();
            jwtUser = new JwtUser();
            jwtUser.setEmail(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get(properties.getId())));
            jwtUser.setRole((String) body.get(properties.getRole()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return jwtUser;
    }
}
