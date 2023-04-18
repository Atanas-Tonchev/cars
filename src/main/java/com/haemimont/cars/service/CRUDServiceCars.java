package com.haemimont.cars.service;

import com.haemimont.cars.model.Car;

import java.util.List;

public interface CRUDServiceCars {

    List<Car> getAllCars();
    Car getCarByID(int carID);
    List<Car> searchCarsByParam(String model, String yearFrom, String yearTo);

    List<String> getCarsMake();

    boolean deleteCar(int carID);
    void insertCar(Car car);
    void updateCar(Car car);

}
