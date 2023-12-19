package com.kotenko.spring.core.car;

import com.kotenko.spring.core.car.data.CarDao;
import com.kotenko.spring.core.car.exceptions.CarNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {
    private final CarDao carDao;

    public CarService(@Qualifier("car-jpa") CarDao carDao) {
        this.carDao = carDao;
    }

    public List<Car> getCars() {
        return carDao.getCars();
    }

    public Car getCarById(String carId) throws IllegalArgumentException {
        return this.getCars().stream()
                .filter(car -> car.getId().equals(UUID.fromString(carId)))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException("car with id: %s not found".formatted(carId)));
    }

    public List<Car> saveCars(List<Car> cars) {
        return carDao.saveCars(cars);
    }
}
