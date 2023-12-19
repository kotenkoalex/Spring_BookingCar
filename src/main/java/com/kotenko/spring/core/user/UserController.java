package com.kotenko.spring.core.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> viewAllUsers() {
        return service.viewAllUsers();
    }

    @GetMapping("{id}")
    public User viewUserById(@PathVariable String id) {
        return service.getUserById(id);
    }
}
