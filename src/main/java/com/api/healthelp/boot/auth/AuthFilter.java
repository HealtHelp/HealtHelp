package com.api.healthelp.boot.auth;

import com.api.healthelp.boot.properties.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private Properties properties;

    public AuthFilter() {
        super("/api/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String header = request.getHeader(properties.getHeader());
        if(header == null || !header.startsWith(properties.getBearer())){
            throw new RuntimeException("ERROR:  HEADER NULL TOKEN MISSING");
        }
        String authenticationToken = header.substring(7);
        AuthToken token = new AuthToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request,response);
    }
}
