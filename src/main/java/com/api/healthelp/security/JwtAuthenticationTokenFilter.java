package com.api.healthelp.security;

import com.api.healthelp.boot.Properties;
import com.api.healthelp.model.JwtAuthenticationToken;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private Properties properties;
    private static final Log logger = LogFactory.getLog(JwtAuthenticationTokenFilter.class);

    public JwtAuthenticationTokenFilter() {
        super("/healthelp/**");

    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, ServletException {

        String header = request.getHeader(properties.getHeader());
        if(header == null || !header.startsWith(properties.getBearer())){
            logger.error(" -- ERROR TOKEN NOT FOUND ");
        }
        if(header!=null){
            String authenticationToken =  header.substring(7,header.length());
            JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request,response);
    }
}
