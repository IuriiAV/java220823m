package com.telran.org.service;

import com.telran.org.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User create(User user);

    User getByLogin(String login);
}
