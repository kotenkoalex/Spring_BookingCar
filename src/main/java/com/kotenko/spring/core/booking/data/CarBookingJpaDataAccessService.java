package com.kotenko.spring.core.booking.data;

import com.kotenko.spring.core.booking.CarBooking;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("carbooking-jpa")
public class CarBookingJpaDataAccessService implements CarBookingDao{
    private final CarBookingRepository repository;

    public CarBookingJpaDataAccessService(CarBookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CarBooking> getCarBookings() {
        return repository.findAll();
    }

    @Override
    public void book(CarBooking carBooking) {
        repository.save(carBooking);
    }

    @Override
    public boolean isBooked(UUID carId) {
        return repository.isBooked(carId);
    }
}
