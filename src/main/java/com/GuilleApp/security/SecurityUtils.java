package com.GuilleApp.security;

import com.GuilleApp.model.users.AppUser;
import com.GuilleApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

@Component
public class SecurityUtils {

    @Autowired
    private UserRepository userRepository;

    public AppUser getLoggedInUser() {
        return userRepository.findByUsername(getUsername()).orElse(null);
    }

    public boolean hasRole(String role) {

        Collection<? extends GrantedAuthority> authorities = getAuthorities();

        return !CollectionUtils.isEmpty(authorities) &&
                authorities.stream().anyMatch(authority -> role.equals(authority.getAuthority()));
    }

    public boolean isAdmin() {
        return hasRole("ROLE_ADMIN");
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return auth() != null ? auth().getAuthorities() : null;
    }


    public String getUsername() {
        return auth() != null ? auth().getName() : null;
    }

    private Authentication auth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


}

