package com.telran.org.service;

import com.telran.org.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //Только для примера, чтобы не подключать БД и хранить там пользователей
    private Map<String, User> inMemoryRepository = new HashMap<>();

    //В реальном примере , все методы этого класса должны обращаться в
    //репозиторий пользователя и забирать его из базы данных, а также
    //сохранять его там

    @Override
    public List<User> getAll() {
        return inMemoryRepository.values().stream().toList();
    }

    @Override
    public User create(User user) {
        user.setId(new Random().nextLong());
        inMemoryRepository.put(user.getLogin(), user);
        return user;
    }

    @Override
    public User getByLogin(String login) {
        return inMemoryRepository.get(login);
    }
}