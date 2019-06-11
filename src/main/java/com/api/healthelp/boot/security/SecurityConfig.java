package com.api.healthelp.boot.security;



import com.api.healthelp.boot.auth.AuthFilter;
import com.api.healthelp.boot.auth.AuthProvider;
import com.api.healthelp.boot.auth.AuthToken;
import com.api.healthelp.boot.auth.JwtSuccessHandler;
import com.api.healthelp.boot.properties.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;


@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Properties properties;
    private AuthProvider authProvider;

    public SecurityConfig(Properties properties,AuthProvider authProvider){
        this.properties = properties;
        this.authProvider = authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(authProvider));
    }

    @Bean
    public AuthFilter authenticationTokenFilter(){
        AuthFilter authFilter = new AuthFilter(properties);
        authFilter.setAuthenticationManager(authenticationManager());
        authFilter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return authFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
               // .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers("/hh/**").authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }



}
