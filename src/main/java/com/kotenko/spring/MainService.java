package com.kotenko.spring;

import com.kotenko.spring.core.booking.CarBooking;
import com.kotenko.spring.core.booking.CarBookingService;
import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.car.Engine;
import com.kotenko.spring.core.user.User;
import com.kotenko.spring.core.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MainService {

    private final UserService userService;
    private final CarBookingService carBookingService;

    public MainService(UserService userService, CarBookingService carBookingService) {
        this.userService = userService;
        this.carBookingService = carBookingService;
    }

    public List<User> viewAllUsers() {
        return userService.getUsers();
    }

    public List<User> viewAllUserBookedCars() {
        List<User> allUserBookedCars = carBookingService.getAllUserBookedCars();
        return allUserBookedCars.stream().anyMatch(Objects::nonNull) ? allUserBookedCars.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()) : null;
    }

    public List<CarBooking> viewAllBookings() {
        return carBookingService.getCarBookings().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<Car> viewAvailableCars() {
        return carBookingService.getAvailableCars();
    }

    public List<Car> viewAvailableElectricCars() {
        return carBookingService.getAvailableCars().stream()
                .filter(availableCar -> availableCar.getEngine() == Engine.ELECTRIC)
                .collect(Collectors.toList());
    }
}
