package com.kotenko.spring.core.booking;

import com.kotenko.spring.core.booking.exceptions.CarBookingNotFoundException;
import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CarBookingController {

    private final CarBookingService service;

    public CarBookingController(CarBookingService service) {
        this.service = service;
    }

    @PostMapping("bookings")
    public void bookCar(@RequestBody CarBookingRequest request) {
        service.bookCar(request);
    }

    @GetMapping("users/booked")
    public List<User> viewAllUserBookedCars() {
        return service.viewAllUserBookedCars();
    }

    @GetMapping("bookings")
    public List<CarBooking> viewAllBookings() {
        return service.viewAllBookings();
    }

    @GetMapping("cars/available")
    public List<Car> viewAvailableCars() {
        return service.viewAvailableCars();
    }

    @GetMapping("cars/available/type")
    public List<Car> viewAvailableElectricCars(@RequestParam String type) {
        if (!type.equals("electric")) {
            throw new CarBookingNotFoundException("Wrong type");
        }
        return service.viewAvailableElectricCars();
    }
}
