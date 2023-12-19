package com.kotenko.spring.core.booking.data;

import com.kotenko.spring.core.booking.CarBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CarBookingRepository extends JpaRepository<CarBooking, UUID> {
    @Query("SELECT COUNT(cb) > 0 FROM CarBooking cb WHERE cb.carBookingId.car.id = :carId")
    boolean isBooked(UUID carId);
}
