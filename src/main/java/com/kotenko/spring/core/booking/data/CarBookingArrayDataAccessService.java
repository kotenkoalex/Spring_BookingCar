package com.kotenko.spring.core.booking.data;

import com.kotenko.spring.core.booking.CarBooking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("carbooking-array")
public class CarBookingArrayDataAccessService implements CarBookingDao {
    private static final List<CarBooking> carBookings;

    static {
        carBookings = new ArrayList<>();
    }

    @Override
    public List<CarBooking> getCarBookings() {
        return carBookings;
    }

    @Override
    public void book(CarBooking carBooking) {
        carBookings.add(carBooking);
    }

    @Override
    public boolean isBooked(UUID carId) {
        return carBookings.stream().map(it->it.getCarBookingId().getCar().getId()).toList().contains(carId);
    }
}
