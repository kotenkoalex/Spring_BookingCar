package com.kotenko.spring.core.booking;

import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.user.User;

public record CarBookingRequest(User user, Car car) {
}
