package com.haemimont.cars.database;

import com.haemimont.cars.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarStatements {

    public static int insertCar(Car car, Connection connection) {
        int result = 0;

//        PreparedStatement preparedStatement for car table ....
//
        try {
            int idDimension = insertDimension(car.getDimensions(), connection);
            int idEngineInformation = insertEngineInformation(car.getEngineInformation(), connection);
            int idFuelInformation = insertFuelInformation(car.getFuelInformation(), connection);
            int idIdentification = insertIdentification(car.getIdentification(), connection);
        } catch (Exception e ) {
            throw new RuntimeException();
        }

        // preparedStatement.execute insert into car....

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

    private static int insertDimension(Dimensions dimensions, Connection connection) throws SQLException {
        int result = 0;

        String sqlDimensions = "INSERT INTO csv_cars_db.dimensions (height,length,width) VALUES( ?,?,? )";

        PreparedStatement statement = connection.prepareStatement(sqlDimensions,
                PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, dimensions.getHeight());
        statement.setInt(2, dimensions.getLength());
        statement.setInt(3, dimensions.getWidth());
        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            result = resultSet.getInt(1);
            System.out.println("Table 'Dimensions' is created with ID: " + result);

        } else {
            System.out.println("No data inserted.");
        }

        statement.close();
        return result;
    }


}
