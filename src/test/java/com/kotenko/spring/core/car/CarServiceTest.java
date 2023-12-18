package com.kotenko.spring.core.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    @Test
    void getAllFiveCars() {
        CarDao dao = new CarArrayDataAccessService();
        CarService service = new CarService(dao);
        assertEquals(5, service.getCars().size());
    }
}