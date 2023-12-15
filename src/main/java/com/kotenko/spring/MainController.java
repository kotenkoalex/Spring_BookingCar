package com.kotenko.spring;

import com.kotenko.spring.core.booking.CarBooking;
import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/users")
    public List<User> viewAllUsers() {
        return service.viewAllUsers();
    }

    @GetMapping("/api/v/1users/booked")
    public List<User> viewAllUserBookedCars() {
        return service.viewAllUserBookedCars();
    }

    @GetMapping("/api/v1/booking")
    public List<CarBooking> viewAllBookings() {
        return service.viewAllBookings();
    }

    @GetMapping("/api/v1/cars/available")
    public List<Car> viewAvailableCars() {
        return service.viewAvailableCars();
    }

    @GetMapping("/api/v1/cars/available/electric")
    public List<Car> viewAvailableElectricCars() {
        return service.viewAvailableElectricCars();
    }
}
