package com.kotenko.spring.core.user.utils;

import com.kotenko.spring.core.user.User;

import java.io.File;
import java.util.List;

public interface IUserReader {
    List<User> readUsers(File file);
}
