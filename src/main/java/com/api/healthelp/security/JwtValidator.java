package com.api.healthelp.security;

import com.api.healthelp.boot.Properties;
import com.api.healthelp.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private Properties properties;

    public JwtValidator(Properties properties) {
        this.properties=properties;
    }

    public JwtUser validate(String token){
        JwtUser jwtUser = null;

        try{
            Claims body = Jwts.parser()
                    .setSigningKey(properties.getBitSecret())
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();
            jwtUser.setUsername(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get(properties.getId())));
            jwtUser.setRole((String) body.get(properties.getRole()));
        }catch (Exception ex){
            System.out.println(ex);
        }
        return jwtUser;
    }
}
