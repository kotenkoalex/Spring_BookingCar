package com.kotenko.spring.core.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class CarBookingException extends RuntimeException {
    public CarBookingException(String message) {
        super(message);
    }
}
