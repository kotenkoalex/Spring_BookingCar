package com.kotenko.spring.core.user;

import com.kotenko.spring.core.user.utils.IUserReader;

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
}
