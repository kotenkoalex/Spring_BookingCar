package com.kotenko.spring.core.booking;

import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarBooking {
    @Id
    private CarBookingId carBookingId;
    private LocalDateTime localDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class CarBookingId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        @OneToOne
        private Car car;
    }
}
