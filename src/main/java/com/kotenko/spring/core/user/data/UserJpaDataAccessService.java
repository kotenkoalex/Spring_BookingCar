package com.kotenko.spring.core.user.data;

import com.kotenko.spring.core.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("user-jpa")
public class UserJpaDataAccessService implements UserDao {
    private final UserRepository repository;

    public UserJpaDataAccessService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }
}
