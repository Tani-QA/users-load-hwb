package com.example.users.service;

//создать реализацию интерфейса UserService

import com.example.users.model.User;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service //Аннотация говорит, что данный класс является сервисом, в котором реализуется некоторая бизнес логика приложения. благодаря этой аннотации Spring будет предоставлять экземпляр данного класса в местах, где это нужно с помощью Dependency Injection
public class UserServiceImpl implements UserService {

    // Хранилище пользователей. Ключ - id пользователя, значение — сам пользователь
    private static final Map<Integer, User> USER_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID пользователя
    private static final AtomicInteger USER_ID_HOLDER = new AtomicInteger();

    //создание пользователя
    @Override
    public void create(User user) {
        final int userId = USER_ID_HOLDER.incrementAndGet();
        user.setId(userId);
        Date createdDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        user.setCreatedDate(formatter.format(createdDate));
        USER_REPOSITORY_MAP.put(userId, user);
    }

    //все пользователи
    @Override
    public List<User> readAll() {
        return new ArrayList<>(USER_REPOSITORY_MAP.values());
    }

    //данные пользователя по его ID
    @Override
    public User read(int id) {
        return USER_REPOSITORY_MAP.get(id);
    }



}
