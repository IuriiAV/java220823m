package com.telran.org.mapper;

import com.telran.org.dto.UserDto;
import com.telran.org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getLogin(), user.getRole());
    }

    @Override
    public User toEntity(UserDto userDto) {
        return new User(userDto.getLogin(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getRole());
    }
}
