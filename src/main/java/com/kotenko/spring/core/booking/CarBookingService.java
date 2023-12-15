package com.kotenko.spring.core.booking;

import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.car.CarService;
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

    public CarBooking bookCar(User user, Car car) {
        CarBooking carBooking;
        if (user != null && car != null) {
            carBooking = new CarBooking(UUID.randomUUID(), user, car, LocalDateTime.now());
            carBookingDao.book(carBooking);
            return carBooking;
        }
        return null;
    }

    public List<CarBooking> getCarBookings() {
        List<CarBooking> carBookings = carBookingDao.getCarBookings()
                .stream()
                .filter(Objects::nonNull)
                .toList();
        if (carBookings.size() == 0) {
            System.out.println("No bookings available");
        }
        return carBookingDao.getCarBookings();
    }

    public List<Car> getAvailableCars() {
        List<UUID> bookedCarIds = carBookingDao.getCarBookings()
                .stream()
                .map(it -> it != null ? it.getCar().getId() : null)
                .filter(Objects::nonNull)
                .toList();
        return carService.getCars()
                .stream()
                .filter(it -> !containsId(bookedCarIds, it.getId()))
                .toList();
    }

    private boolean containsId(List<UUID> bookedCarIds, UUID id) {
        for (UUID bookedCarId : bookedCarIds) {
            if (bookedCarId != null && bookedCarId.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getAllUserBookedCars() {
        return carBookingDao.getCarBookings()
                .stream()
                .filter(Objects::nonNull)
                .map(CarBooking::getUser)
                .distinct()
                .toList();
    }
}
