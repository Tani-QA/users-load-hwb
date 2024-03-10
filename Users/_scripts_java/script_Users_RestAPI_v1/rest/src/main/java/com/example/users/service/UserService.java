package com.example.users.service;
//В сервисе (помечен как @Service) будут реализованы CRUD операции над пользователем

import com.example.users.model.User;

import java.util.List;

public interface UserService {

//      Создает нового пользователя
//      @param user - пользователь для создания
    void create(User user);

//      Возвращает список всех имеющихся пользователей
//      @return список пользователей
    List<User> readAll();

//      Возвращает пользователя по его ID
//      @param id - ID пользователя
//      @return - объект пользователя с заданным ID
    User read(int id);


}
