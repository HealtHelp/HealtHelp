package com.api.healthelp.boot.auth;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class JwtUserDetails implements UserDetails {

    private String email;
    private String token;
    private Long id;
    private Collection<? extends GrantedAuthority> authorities;


    public JwtUserDetails(String userName, long id, String token, List<GrantedAuthority> grantedAuthorities) {
        this.email = userName;
        this.id = id;
        this.token= token;
        this.authorities = grantedAuthorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
