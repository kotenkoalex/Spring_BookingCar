package com.kotenko.spring.core.user;

import com.kotenko.spring.core.user.data.UserDao;
import com.kotenko.spring.core.user.data.UserFakerDataAccessService;
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