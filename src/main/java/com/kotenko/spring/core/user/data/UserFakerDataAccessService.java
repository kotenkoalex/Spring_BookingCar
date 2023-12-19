package com.kotenko.spring.core.user.data;

import com.github.javafaker.Faker;
import com.kotenko.spring.core.user.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("user-faker")
public class UserFakerDataAccessService implements UserDao {
    private List<User> users;

    @Override
    public List<User> getUsers() {
        if (users == null) {
            Faker faker = new Faker();
            int userAmount = 20;
            List<User> users = new ArrayList<>();
            for (int i = 0; i < userAmount; i++) {
                UUID id = UUID.randomUUID();
                String name = faker.name().firstName();
                users.add(new User(id, name));
            }
            this.users = users;
            return users;
        } else {
            return users;
        }
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        this.users.addAll(users);
        return this.users;
    }

    @Override
    public User addUser(User user) {
        this.users.add(user);
        return user;
    }
}
