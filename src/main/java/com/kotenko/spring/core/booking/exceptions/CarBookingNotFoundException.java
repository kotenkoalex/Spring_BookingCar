package com.kotenko.spring.core.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CarBookingNotFoundException extends RuntimeException {
    public CarBookingNotFoundException(String message) {
        super(message);
    }
}
