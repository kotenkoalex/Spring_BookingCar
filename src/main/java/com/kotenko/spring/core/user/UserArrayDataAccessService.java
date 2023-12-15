package com.kotenko.spring.core.user;

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
