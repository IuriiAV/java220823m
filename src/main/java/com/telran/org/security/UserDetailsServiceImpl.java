package com.telran.org.security;

import com.telran.org.entity.User;
import com.telran.org.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByLogin(username);

        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                //42342j4h2jhkjwhrjhjfhsjdfsfsfjhhsjdfksf
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole())));
    }
}
