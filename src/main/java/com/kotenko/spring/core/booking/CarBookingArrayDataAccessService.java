package com.kotenko.spring.core.booking;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
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
    public boolean isBooked(List<UUID> bookedCarIds, UUID id) {
        for (UUID bookedCarId : bookedCarIds) {
            if (bookedCarId != null && bookedCarId.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
