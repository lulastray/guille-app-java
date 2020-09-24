package com.GuilleApp.service.users;


import com.GuilleApp.model.users.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void create(AppUser user);
    AppUser findByUsername(String username);
    void addPoints(Long points);
    void substractPoints(Long points);
}
