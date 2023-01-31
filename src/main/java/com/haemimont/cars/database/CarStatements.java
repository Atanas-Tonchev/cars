package com.haemimont.cars.database;

import com.haemimont.cars.model.*;

import java.sql.Connection;

public class CarStatements {

    public static int insertCar(Car car, Connection connection) {
        int result = 0;

//        PreparedStatement preparedStatement ....
//
        int idDimension = insertDimension(car.getDimensions(), connection);
        int idEngineInformation = insertEngineInformation(car.getEngineInformation(), connection);
        int idFuelInformation = insertFuelInformation(car.getFuelInformation(), connection);
        int idIdentification = insertIdentification(car.getIdentification(), connection);

        // preparedStatement.execute....


        return result;
    }

    private static int insertIdentification(Identification identification, Connection connection) {
        return 0;
    }

    private static int insertFuelInformation(FuelInformation fuelInformation, Connection connection) {
        return 0;
    }

    private static int insertEngineInformation(EngineInformation engineInformation, Connection connection) {
        return 0;
    }

    private static int insertDimension(Dimensions dimensions, Connection connection) {
        return 0;
    }


}
