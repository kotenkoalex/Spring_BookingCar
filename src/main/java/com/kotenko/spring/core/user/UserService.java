package com.kotenko.spring.core.user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User getUserById(String userId) throws IllegalArgumentException {
        return this.getUsers().stream()
                .filter(user -> user.getId().equals(UUID.fromString(userId)))
                .findFirst()
                .orElse(null);
    }
}
