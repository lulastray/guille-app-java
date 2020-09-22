package com.GuilleApp.service.users;

import com.GuilleApp.model.users.AppUser;
import com.GuilleApp.repository.UserRepository;
import com.GuilleApp.service.exceptions.UserWithoutRoles;
import com.GuilleApp.service.exceptions.UsernameNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = findByUsername(username);

        if (!user.hasRoles()) {
            throw new UserWithoutRoles(username);
        }

        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFound(username));
    }

    @Override
    @Transactional
    public void create(AppUser user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        userRepository.save(user);
    }
}
