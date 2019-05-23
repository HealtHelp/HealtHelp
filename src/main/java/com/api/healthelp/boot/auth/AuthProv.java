package com.api.healthelp.boot.auth;


import com.api.healthelp.model.security.JwtUser;
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
public class AuthProv extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private AuthClaims authClaims;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        AuthToken authToken = (AuthToken) authentication;
        String token = authToken.getToken();
        JwtUser jwtUser = this.authClaims.validate(token);
        if(jwtUser != null){throw  new RuntimeException("ERROR:JWT INCORRECT");}
        List<GrantedAuthority> grantedAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
        return new UserDetail(jwtUser.getId(),jwtUser.getEmail(),token,grantedAuthorityList);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (AuthToken.class.isAssignableFrom(authentication));
    }
}
