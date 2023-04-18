package com.haemimont.cars.service;

import com.haemimont.cars.database.CarSearchStatements;
import com.haemimont.cars.database.CarStatements;
import com.haemimont.cars.model.Car;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CarService implements CRUDServiceCars{
    Connection connection = null;

    public CarService() {
        try {
            connection = ConnectMySqlToTomcat.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<String> getCarsMake() {
        return CarStatements.allModels(connection);
    }

    @Override
    public List<Car> getAllCars() {
        return CarStatements.allCars(connection);
    }

    @Override
    public Car getCarByID(int carID) {
        return CarStatements.carByID(connection, carID);
    }

    @Override
    public List<Car> searchCarsByParam(String model, String yearFrom, String yearTo) {
        return CarSearchStatements.carsByParam(connection,model,yearFrom,yearTo);
    }

    public boolean deleteCar(int carID){
        CarStatements.delete(carID, connection);
        return false;
    }

    @Override
    public void insertCar(Car car) {
        CarStatements.insert(car, connection);
    }

    @Override
    public void updateCar(Car car) {
        CarStatements.update(car, connection);
    }
}

