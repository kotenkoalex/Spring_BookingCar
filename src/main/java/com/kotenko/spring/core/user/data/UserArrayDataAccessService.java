package com.kotenko.spring.core.user.data;

import com.kotenko.spring.core.user.User;
import com.kotenko.spring.core.user.utils.IUserReader;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

public class UserArrayDataAccessService implements UserDao {
    private final List<User> users;

    public UserArrayDataAccessService(IUserReader iUserReader, File file) {
        users = iUserReader.readUsers(file);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        this.users.addAll(users);
        return this.users;
    }
}
