package com.api.healthelp.boot.security;


import com.api.healthelp.boot.auth.AuthProv;
import com.api.healthelp.boot.auth.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private AuthProv authProv;

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(Collections.singletonList(authProv));
    }

    @Bean
    public AuthFilter authenticationTokenFilter(){
        AuthFilter filter = new AuthFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
             http.cors().and()
                 .csrf().disable()
                 .authorizeRequests()
                     .antMatchers(HttpMethod.POST,"/login").permitAll()
                     .antMatchers(HttpMethod.GET,"/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
                     .antMatchers("/api/**")
                .authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
              http.addFilterBefore(authenticationTokenFilter(),UsernamePasswordAuthenticationFilter.class);
              http.headers().cacheControl();
    }


}
