package com.telran.org.controller;

import com.telran.org.dto.UserDto;
import com.telran.org.entity.User;
import com.telran.org.mapper.Mapper;
import com.telran.org.security.AuthenticationService;
import com.telran.org.security.model.JwtAuthenticationResponse;
import com.telran.org.security.model.SignInRequest;
import com.telran.org.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthenticationService authenticationService;

    private final PasswordEncoder passwordEncoder;

    private final Mapper<User, UserDto> mapper;

    @GetMapping
    public List<UserDto> listAll() {
        return userService.getAll()
                .stream()
                .map(user -> mapper.toDto(user))
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserDto register(@RequestBody UserDto userDto) {
        return mapper.toDto(userService.create(mapper.toEntity(userDto)));
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody SignInRequest request) {
        return authenticationService.authenticate(request);
    }
}
