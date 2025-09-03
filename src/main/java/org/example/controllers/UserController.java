package org.example.controllers;

import org.example.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return List.of(
                new User("Tiago", "tiago@email.com", "1234678"),
                new User("João", "joao@email.com", "12345678"),
                new User("Maria", "maria@email.com", "12345678")
        );
    }
}
