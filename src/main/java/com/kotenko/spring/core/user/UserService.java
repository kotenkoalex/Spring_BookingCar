package com.kotenko.spring.core.user;

import com.kotenko.spring.core.user.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> viewAllUsers() {
        return userDao.getUsers();
    }

    public User getUserById(String userId) throws IllegalArgumentException {
        return this.viewAllUsers().stream()
                .filter(user -> user.getId().equals(UUID.fromString(userId)))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("user with id: %s not found".formatted(userId)));
    }
}
