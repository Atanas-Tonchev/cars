package com.haemimont.cars.service;

import com.haemimont.cars.model.Car;

import java.util.List;

public interface CRUDService {

    List<Car> getAllCars();

    Car getCarByID(int carID);

    List<Car> getCarByMake(String carMake);

}
