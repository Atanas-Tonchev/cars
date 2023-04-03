package com.haemimont.cars.service;

import com.haemimont.cars.model.Car;

import java.util.List;

public interface CRUDServiceCars {

    List<Car> getAllCars();

    Car getCarByID(int carID);
    List<Car> getCarByYear(int fromYear, int toYear);
    List<Car> getCarByMake(String make);


    /*boolean deleteCar(Car car);*/
    boolean deleteCar(int carID);
    void insertCar(Car car);
    void updateCar(Car car);

}
