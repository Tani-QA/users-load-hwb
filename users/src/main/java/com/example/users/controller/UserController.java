package com.example.users.controller;


import com.example.users.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> getUser() {
        User userGet = new User("login1", "password1", "2024-03-01");
        return new ResponseEntity<>(userGet, HttpStatus.OK);
    }

    //второй вариант с валидацией передачи в теле запроса доп.ключей
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> userKey) {

        if ((userKey.size() != 2) || (!userKey.containsKey("login") || !userKey.containsKey("password")) ||
                isValidString(userKey.get("login"),userKey.get("password")) || isValidEmpty(userKey.get("login"),userKey.get("password"))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setLogin(userKey.get("login").toString());
        user.setPassword(userKey.get("password").toString());
        user.setCreatedData();

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //строки ++
    private boolean isValidString(Object login, Object password) {
        return !(login instanceof String && password instanceof String);
    }

    //пустое значение "" ++
    private boolean isValidEmpty(Object login, Object password) {
        return ((String)login).isEmpty() || ((String)password).isEmpty();
    }

}

