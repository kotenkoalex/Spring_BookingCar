package com.kotenko.spring;

import com.kotenko.spring.core.car.Car;
import com.kotenko.spring.core.car.CarService;
import com.kotenko.spring.core.car.data.CarArrayDataAccessService;
import com.kotenko.spring.core.user.User;
import com.kotenko.spring.core.user.UserService;
import com.kotenko.spring.core.user.data.UserFakerDataAccessService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarBookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarBookingApplication.class, args);
    }

    @Bean
    public List<User> addUsers(UserFakerDataAccessService userFakerDataAccessService, UserService userService) {
        List<User> users = userFakerDataAccessService.getUsers();

        return userService.saveUsers(users);
    }

    @Bean
    public List<Car> addCars(CarArrayDataAccessService carArrayDataAccessService, CarService carService) {
        List<Car> cars = carArrayDataAccessService.getCars();
        return carService.saveCars(cars);
    }
}
