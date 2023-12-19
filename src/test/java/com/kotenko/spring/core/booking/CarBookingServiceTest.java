package com.kotenko.spring.core.booking;

import com.kotenko.spring.core.booking.data.CarBookingArrayDataAccessService;
import com.kotenko.spring.core.booking.data.CarBookingDao;
import com.kotenko.spring.core.booking.exceptions.CarBookingException;
import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.car.data.CarArrayDataAccessService;
import com.kotenko.spring.core.car.data.CarDao;
import com.kotenko.spring.core.car.CarService;
import com.kotenko.spring.core.user.User;
import com.kotenko.spring.core.user.data.UserDao;
import com.kotenko.spring.core.user.data.UserFakerDataAccessService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarBookingServiceTest {
    private final UserDao userDao = new UserFakerDataAccessService();
    private final CarDao carDao = new CarArrayDataAccessService();
    private final CarService carService = new CarService(carDao);
    private final CarBookingDao carBookingDao = new CarBookingArrayDataAccessService();
    private final CarBookingService carBookingService = new CarBookingService(carBookingDao, carService);

    @Test
    void bookCar() {
        User user = userDao.getUsers().get(0);
        Car car = carService.getCars().get(0);
        CarBookingRequest request = new CarBookingRequest(user, car);
        carBookingService.bookCar(request);
        assertEquals(1, carBookingService.viewAllUserBookedCars().size());
    }

    @Test
    void viewAllUserBookedCars() {
        assertEquals(1, carBookingService.viewAllUserBookedCars().size());
    }

    @Test
    void viewAllBookings() {
        assertThrows(CarBookingException.class, carBookingService::viewAllBookings);
    }

    @Test
    void viewAvailableCars() {
        assertEquals(5, carBookingService.viewAvailableCars().size());
    }

    @Test
    void viewAvailableElectricCars() {
        assertEquals(2, carBookingService.viewAvailableElectricCars().size());
    }
}