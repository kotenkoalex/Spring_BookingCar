package com.kotenko.spring.core.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getAllTwentyUsers() {
        UserDao dao = new UserFakerDataAccessService();
        UserService service = new UserService(dao);
        assertEquals(20, service.viewAllUsers().size());
    }
}