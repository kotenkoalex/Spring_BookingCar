package com.kotenko.spring.core.car.data;

import com.kotenko.spring.core.car.Car;

import java.util.List;

public interface CarDao {
    List<Car> getCars();

    List<Car> saveCars(List<Car> cars);
}
