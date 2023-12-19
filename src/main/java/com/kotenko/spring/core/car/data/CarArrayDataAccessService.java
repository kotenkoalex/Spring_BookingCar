package com.kotenko.spring.core.car.data;

import com.kotenko.spring.core.car.Brand;
import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.car.Engine;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("car-array")
public class CarArrayDataAccessService implements CarDao {
    private final static List<Car> cars;

    static {
        cars = List.of(
                new Car(UUID.randomUUID(), Engine.ELECTRIC, Brand.BMW),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.CITROEN),
                new Car(UUID.randomUUID(), Engine.ELECTRIC, Brand.TESLA),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MERCEDES),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MAZDA));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> saveCars(List<Car> cars) {
        CarArrayDataAccessService.cars.addAll(cars);
        return CarArrayDataAccessService.cars;
    }
}
