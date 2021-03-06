package com.api.healthelp.boot.auth;

import com.api.healthelp.boot.properties.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private Properties properties;


    public AuthFilter(Properties properties) {
        super("/api/**");
        this.properties = properties;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String header = request.getHeader(properties.getHeader());
        if (header == null || !header.startsWith(properties.getBearer())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Token is missing");
        }
        String authenticationToken = header.substring(7);
        AuthToken authToken = new AuthToken(authenticationToken);
        return getAuthenticationManager().authenticate(authToken);
    }



    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
