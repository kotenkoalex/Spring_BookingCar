package com.kotenko.spring.core.booking;

import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarBooking {
    @Id
    private UUID bookingId;
    @OneToOne
    private User user;
    @OneToOne
    private Car car;
    private LocalDateTime localDateTime;
}
