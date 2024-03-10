package com.example.users.controller;
//контроллер - спец. класс, где реализуется логика обработки клиентских запросов на эндпоинты

import com.example.users.model.User;
import com.example.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController //данный класс является REST контроллером, будет реализована логика обработки клиентских запросов
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService; //внедрить в зависимость от UserService

    @Autowired //в этом месте необходимо внедрить зависимость
    public UserController(UserService userService) { //передаем интерфейс UserService, спринг сможет передать экземпляр этой реализации в конструктор контроллера
        this.userService = userService;
    }

    //POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) { //значение этого параметра подставляется из тела запроса
        userService.create(user); //вызываем метод create у сервиса и передаем ему принятого в параметрах контроллера клиента
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //GET all users
    @GetMapping
    public ResponseEntity<List<User>> read() {
        final List<User> users = userService.readAll();
        return users != null &&  !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") int id) {
        final User user = userService.read(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
