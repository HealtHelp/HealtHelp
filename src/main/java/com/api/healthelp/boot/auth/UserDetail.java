package com.api.healthelp.boot.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

@Getter
public class UserDetail implements UserDetails {

    private Long id;
    private String email;
    private String token;
    private List<GrantedAuthority> grantedAuthorityList;

    public UserDetail(Long id, String email, String token, List<GrantedAuthority> grantedAuthorityList) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.grantedAuthorityList = grantedAuthorityList;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return this.grantedAuthorityList;
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
