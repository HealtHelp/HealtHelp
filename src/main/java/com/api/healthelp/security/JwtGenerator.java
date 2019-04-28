package com.api.healthelp.security;

import com.api.healthelp.boot.Properties;
import com.api.healthelp.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@Component
public class JwtGenerator implements Serializable {

    private Properties properties;

    public JwtGenerator(Properties properties){
        this.properties=properties;
    }

    public String generate(JwtUser jwtUser){


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUsername());
             claims.put(properties.getId(),jwtUser.getId());
             claims.put(properties.getRole(),jwtUser.getRole());

             return Jwts.builder()
                     .setClaims(claims)
                     .signWith(SignatureAlgorithm.HS256,properties.getBitSecret())
                     .setExpiration(Date.from(Instant.now().plusSeconds(Long.valueOf(3600))))
                     .compact();
    }
}
