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

        } catch (Exception e) {
            throw new RuntimeException();
        }

        // preparedStatement.execute insert into car....

        return result;
    }

    private static int insertEngineStatic(EngineStatistics engineStatistics, Connection connection) {
        int result = 0;

        String sqlStatic = "INSERT INTO csv_cars_db.engine_statistics (horsepower,torque) VALUES( ?,? )";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlStatic, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, engineStatistics.getHorsepower());
            statement.setInt(2, engineStatistics.getTorque());

            statement.executeUpdate();

            ResultSet resultStatic = statement.getGeneratedKeys();

            if (resultStatic.next()) {
                result = resultStatic.getInt(1);
                System.out.println("Table 'Engine Static' is created with ID: " + result);
            } else {
                System.out.println("No data inserted.");
            } statement.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }

    private static int insertIdentification(Identification identification, Connection connection) {
       int result = 0;

        try {
            String sqlIdentification = "INSERT INTO csv_cars_db.identification (classification,id,make,model_year,year)" +
                    " VALUES( ?,?,?,?,? )";


            PreparedStatement statement = connection.prepareStatement(sqlIdentification,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1,identification.getClassification());
            statement.setString(2,identification.getID());
            statement.setString(3,identification.getMake());
            statement.setString(4,identification.getModelYear());
            statement.setInt(5,identification.getYear());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
                System.out.println("Table 'Identification' is created with ID: " + result);
            } else {
                System.out.println("No data inserted.");
            }statement.close();

        }catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }

    private static int insertFuelInformation(FuelInformation fuelInformation, Connection connection) {
        int result = 0;

        try {
            String sqlFuel = "INSERT INTO csv_cars_db.fuel_information (fuel_type,city_mpg,highway_mpg) VALUES( ?,?,? )";

            PreparedStatement statement = connection.prepareStatement(sqlFuel, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, fuelInformation.getFuelType());
            statement.setInt(2, fuelInformation.getCityMpg());
            statement.setInt(3, fuelInformation.getHighwayMpg());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
                System.out.println("Table 'Fuel Information' is created with ID: " + result);
            } else {
                System.out.println("No data inserted.");
            }statement.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }

    private static int insertEngineInformation(EngineInformation engineInformation, Connection connection)  {
        int result = 0;

        String sqlEngineInformation = "INSERT INTO csv_cars_db.engine_information (drive_line,engine_type,hybrid," +
                "transmission,number_of_forward_gears,engine_statistics_engine_statistics_id)" +
                " VALUES( ?,?,?,?,?,? )";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlEngineInformation,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            int idEngineStatic = insertEngineStatic(engineInformation.getEngineStatistics(), connection);

            statement.setString(1, engineInformation.getDriveLine());
            statement.setString(2, engineInformation.getEngineType());
            statement.setString(3, engineInformation.getHybrid());
            statement.setString(4, engineInformation.getTransmission());
            statement.setInt(5, engineInformation.getNumberOfForwardGears());
            statement.setInt(6, idEngineStatic);

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
                System.out.println("Table 'Engine Information' is created with ID: " + result);

            } else {
                System.out.println("No data inserted.");
            } statement.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }

    private static int insertDimension(Dimensions dimensions, Connection connection) {
        int result = 0;

        String sqlDimensions = "INSERT INTO csv_cars_db.dimensions (height,length,width) VALUES( ?,?,? )";

        try {
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
            } statement.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }
}
