package com.kotenko.spring.core.car;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {
    private final CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public List<Car> getCars() {
        return carDao.getCars();
    }

    public Car getCarById(String carId) throws IllegalArgumentException {
        return this.getCars().stream()
                .filter(car -> car.getId().equals(UUID.fromString(carId)))
                .findFirst()
                .orElse(null);
    }
}
