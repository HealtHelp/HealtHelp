package com.api.healthelp.boot.security;


import com.api.healthelp.boot.properties.Properties;
import com.api.healthelp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Properties properties;

    public SecurityConfig(Properties properties,UserDao userDao) {
        this.properties = properties;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception {
        super.configure(auth);
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("healthelp")).roles("ADMIN");
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/v2/api-docs","/configuration/ui","/swagger-resources","/configuration/security","/swagger-ui.html","/webjars/**").permitAll()
                .antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/user").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/user").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .logout()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
