package com.kotenko.spring.core.booking;

import com.kotenko.spring.core.booking.data.CarBookingDao;
import com.kotenko.spring.core.booking.exceptions.CarBookingException;
import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.car.CarService;
import com.kotenko.spring.core.car.Engine;
import com.kotenko.spring.core.user.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CarBookingService {
    private final CarBookingDao carBookingDao;
    private final CarService carService;

    public CarBookingService(@Qualifier("carbooking-jpa") CarBookingDao carBookingDao, CarService carService) {
        this.carBookingDao = carBookingDao;
        this.carService = carService;
    }

    public void bookCar(CarBookingRequest request) {
        if (request.user() != null && request.car() != null) {
            if (!carBookingDao.isBooked(request.car().getId())) {
                carBookingDao.book(new CarBooking(
                        new CarBooking.CarBookingId(request.user(), request.car()),
                        LocalDateTime.now()));
            } else {
                throw new CarBookingException("Can't book car");
            }
        }
    }

    public List<User> viewAllUserBookedCars() {
        List<User> allUserBookedCars = carBookingDao.getCarBookings().stream()
                .filter(Objects::nonNull)
                .map(it->it.getCarBookingId().getUser())
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
                .map(it -> it != null ? it.getCarBookingId().getCar().getId() : null)
                .filter(Objects::nonNull)
                .toList();
        List<Car> allCarsId = carService.getCars();
        return allCarsId.stream()
                .filter(car -> !bookedCarIds.contains(car.getId()))
                .toList();
    }

    public List<Car> viewAvailableElectricCars() {
        return viewAvailableCars().stream()
                .filter(availableCar -> availableCar.getEngine() == Engine.ELECTRIC)
                .toList();
    }
}
