package com.kotenko.spring.core.car.data;

import com.kotenko.spring.core.car.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("car-jpa")
public class CarJpaDataAccessService implements CarDao {

    private final CarRepository repository;

    public CarJpaDataAccessService(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> getCars() {
        return repository.findAll();
    }

    @Override
    public List<Car> saveCars(List<Car> cars) {
        return repository.saveAll(cars);
    }
}
