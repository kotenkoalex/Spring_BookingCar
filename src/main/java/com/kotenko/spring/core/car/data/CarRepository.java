package com.kotenko.spring.core.car.data;

import com.kotenko.spring.core.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
