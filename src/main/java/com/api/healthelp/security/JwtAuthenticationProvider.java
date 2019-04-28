package com.api.healthelp.security;


import com.api.healthelp.model.JwtAuthenticationToken;
import com.api.healthelp.model.JwtUser;
import com.api.healthelp.model.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {



    @Autowired
    private JwtValidator validator;


    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;

        String token = jwtAuthenticationToken.getToken();
        JwtUser jwtUser =validator.validate(token);

        /*
        *  public JwtUser validate(String token){
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
        * */

        if(jwtUser == null){
            return null;
        }

        List<GrantedAuthority> grantedAuthorityList = AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());
        return new JwtUserDetails(jwtUser.getUsername(), jwtUser.getId(), token, grantedAuthorityList);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
