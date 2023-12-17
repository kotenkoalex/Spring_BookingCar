package com.kotenko.spring.core.booking;

import com.kotenko.spring.core.booking.exceptions.CarBookingException;
import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.car.CarService;
import com.kotenko.spring.core.car.Engine;
import com.kotenko.spring.core.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CarBookingService {
    private final CarBookingDao carBookingDao;
    private final CarService carService;

    public CarBookingService(CarBookingDao carBookingDao, CarService carService) {
        this.carBookingDao = carBookingDao;
        this.carService = carService;
    }

    public void bookCar(CarBookingRequest request) {
        if (request.user() != null && request.car() != null) {
            if (viewAvailableCars().contains(request.car())) {
                carBookingDao.book(new CarBooking(
                        UUID.randomUUID(),
                        request.user(),
                        request.car(),
                        LocalDateTime.now()));
            } else {
                throw new CarBookingException("Can't book car");
            }
        }
    }

    public List<User> viewAllUserBookedCars() {
        List<User> allUserBookedCars = carBookingDao.getCarBookings().stream()
                .filter(Objects::nonNull)
                .map(CarBooking::getUser)
                .distinct()
                .toList();
        return allUserBookedCars.stream().anyMatch(Objects::nonNull) ? allUserBookedCars.stream()
                .filter(Objects::nonNull)
                .toList() : null;
    }

    public List<CarBooking> viewAllBookings() {
        List<CarBooking> carBookings = carBookingDao.getCarBookings().stream()
                .filter(Objects::nonNull)
                .toList();
        if (carBookings.size() == 0) {
            throw new CarBookingException("No bookings available");
        }
        return carBookingDao.getCarBookings();
    }

    public List<Car> viewAvailableCars() {
        List<UUID> bookedCarIds = carBookingDao.getCarBookings().stream()
                .map(it -> it != null ? it.getCar().getId() : null)
                .filter(Objects::nonNull)
                .toList();
        return carService.getCars().stream()
                .filter(it -> !carBookingDao.isBooked(bookedCarIds, it.getId()))
                .toList();
    }

    public List<Car> viewAvailableElectricCars() {
        return viewAvailableCars().stream()
                .filter(availableCar -> availableCar.getEngine() == Engine.ELECTRIC)
                .toList();
    }
}
