package com.api.healthelp.boot.auth;

import com.api.healthelp.model.security.JwtUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class AuthProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private AuthClaims authClaims;

    public AuthProvider(AuthClaims authClaims){
        this.authClaims = authClaims;
    }


    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        AuthToken authToken = (AuthToken) authentication;
        String token = authToken.getToken();
        JwtUser jwtUser = authClaims.validate(token);
        if (jwtUser == null) {
            throw new RuntimeException("JWT Token is incorrect");
        }
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());
        return new JwtUserDetails(jwtUser.getEmail(), jwtUser.getId(), token, grantedAuthorities);
    }
}
