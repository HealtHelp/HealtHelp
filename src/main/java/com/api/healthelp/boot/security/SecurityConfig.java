package com.api.healthelp.boot.security;

import com.api.healthelp.boot.filter.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("healthelp")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("emple1").password(passwordEncoder().encode("emple1")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable().cors().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
                .antMatchers(HttpMethod.GET,"/users").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST,"/user").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/user").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
