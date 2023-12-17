package com.kotenko.spring.core.booking;

import java.util.List;
import java.util.UUID;

public interface CarBookingDao {
    List<CarBooking> getCarBookings();

    void book(CarBooking carBooking);

    boolean isBooked(List<UUID> bookedCarIds, UUID id);
}
