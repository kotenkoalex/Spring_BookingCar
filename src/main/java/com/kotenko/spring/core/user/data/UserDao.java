package com.kotenko.spring.core.user.data;

import com.kotenko.spring.core.user.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    List<User> saveUsers(List<User> users);
    User addUser(User user);
}
