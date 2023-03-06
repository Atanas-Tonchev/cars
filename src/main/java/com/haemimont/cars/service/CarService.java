package com.haemimont.cars.service;

import com.haemimont.cars.database.CarStatements;
import com.haemimont.cars.model.Car;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CarService implements CRUDService{

    Connection connection = null;

    public CarService() {
        ConnectMySqlToTomcat connectMySqlToTomcat = new ConnectMySqlToTomcat();
        try {
            connection = connectMySqlToTomcat.getConnection();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Car> getAllCars() {
        return CarStatements.getCars(connection);
    }

    @Override
    public Car getCarByID(int carID) {
        return CarStatements.getCarByID(connection, carID);
    }




    @Override
    public boolean insertNewCars(Car car) {
        return CarStatements.insertNewCar(car,connection);
    }

    @Override
    public boolean deleteCar(Car car) {
        return CarStatements.deleteCar(car,connection);
    }

    @Override
    public boolean updateCar(Car car) {
        return CarStatements.updateCar(car,connection);
    }

    @Override
    public List<Car> getLastCarInserted() {
        return CarStatements.getLastCarsInserted(connection);
    }

}
