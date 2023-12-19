package com.kotenko.spring.core.booking.data;

import com.kotenko.spring.core.booking.CarBooking;

import java.util.List;
import java.util.UUID;

public interface CarBookingDao {
    List<CarBooking> getCarBookings();

    void book(CarBooking carBooking);

    boolean isBooked(UUID carId);
}
