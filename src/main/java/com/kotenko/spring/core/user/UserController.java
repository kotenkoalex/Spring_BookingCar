package com.kotenko.spring.core.user;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public User addUser(@RequestBody User user){
        return service.addUser(user);
    }
}
