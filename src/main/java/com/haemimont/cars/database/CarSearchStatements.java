package com.haemimont.cars.database;
import com.haemimont.cars.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarSearchStatements {

    public static List<Car> carsByYear(Connection connection, int yearFrom, int yearTo) {
        List<Car> myList = new ArrayList<>();
        String sqlCarsById = "SELECT " +
                "car_id,height,length,width,drive_line,engine_type,hybrid,transmission," +
                "number_of_forward_gears,horsepower,torque,fuel_type," +
                "city_mpg,highway_mpg,classification,identification.id,make,model_year,identification.year " +
                "FROM " +
                "csv_cars_db.car " +
                "INNER JOIN " +
                "csv_cars_db.dimensions " +
                "ON " +
                "dimensions.dimensions_id = car.dimensions_dimensions_id " +
                "INNER JOIN " +
                "csv_cars_db.engine_information " +
                "ON " +
                "engine_information.engine_information_id = car.engine_information_engine_information_id " +
                "INNER JOIN " +
                "csv_cars_db.engine_statistics " +
                "ON " +
                "engine_statistics.engine_statistics_id = engine_information.engine_statistics_engine_statistics_id " +
                "INNER JOIN " +
                "csv_cars_db.fuel_information " +
                "ON " +
                "fuel_information.fuel_information_id = car.fuel_information_fuel_information_id " +
                "INNER JOIN " +
                "csv_cars_db.identification " +
                "ON " +
                "identification.identification_id = car.identification_identification_id " +
                "WHERE identification.year >= ? and identification.year <= ?";


        try {
            Car car = new Car();
            PreparedStatement statement = connection.prepareStatement(sqlCarsById);
            statement.setInt(1, yearFrom);
            statement.setInt(2,yearTo);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                car.setId(Integer.parseInt(resultSet.getString("car_id")));
                car.setDimensions(new Dimensions(resultSet.getInt("height"),
                        resultSet.getInt("length"), resultSet.getInt("width")));
                car.setEngineInformation(new EngineInformation(resultSet.getString("drive_line"),
                        resultSet.getString("engine_type"),
                        resultSet.getString("hybrid"), resultSet.getString("transmission"),
                        resultSet.getInt("number_of_forward_gears"),
                        new EngineStatistics(resultSet.getInt("horsepower"),
                                resultSet.getInt("torque"))));
                car.setFuelInformation(new FuelInformation(resultSet.getString("fuel_type"),
                        resultSet.getInt("city_mpg"), resultSet.getInt("highway_mpg")));
                car.setIdentification(new Identification(resultSet.getString("classification"),
                        resultSet.getString("id"), resultSet.getString("make"),
                        resultSet.getString("model_year"), resultSet.getInt("year")));

                myList.add(car);

            }
            System.out.println("--correct find by year cars");
            statement.close();
            return myList;

        } catch(SQLException e) {
            System.out.println("--incorrect find by year cars. " + e.getMessage());
            return null;
        }
    }
    public static List<Car> carsByMake(Connection connection, String make) {
        List<Car> myList = new ArrayList<>();
        String sqlCarsByMake = "SELECT " +
                "car_id,height,length,width,drive_line,engine_type,hybrid,transmission," +
                "number_of_forward_gears,horsepower,torque,fuel_type," +
                "city_mpg,highway_mpg,classification,identification.id,make,model_year,identification.year " +
                "FROM " +
                "csv_cars_db.car " +
                "INNER JOIN " +
                "csv_cars_db.dimensions " +
                "ON " +
                "dimensions.dimensions_id = car.dimensions_dimensions_id " +
                "INNER JOIN " +
                "csv_cars_db.engine_information " +
                "ON " +
                "engine_information.engine_information_id = car.engine_information_engine_information_id " +
                "INNER JOIN " +
                "csv_cars_db.engine_statistics " +
                "ON " +
                "engine_statistics.engine_statistics_id = engine_information.engine_statistics_engine_statistics_id " +
                "INNER JOIN " +
                "csv_cars_db.fuel_information " +
                "ON " +
                "fuel_information.fuel_information_id = car.fuel_information_fuel_information_id " +
                "INNER JOIN " +
                "csv_cars_db.identification " +
                "ON " +
                "identification.identification_id = car.identification_identification_id " +
                "WHERE identification.make = ?";


        try {
            Car car = new Car();
            PreparedStatement statement = connection.prepareStatement(sqlCarsByMake);
            statement.setString(1, make);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                car.setId(Integer.parseInt(resultSet.getString("car_id")));
                car.setDimensions(new Dimensions(resultSet.getInt("height"),
                        resultSet.getInt("length"), resultSet.getInt("width")));
                car.setEngineInformation(new EngineInformation(resultSet.getString("drive_line"),
                        resultSet.getString("engine_type"),
                        resultSet.getString("hybrid"), resultSet.getString("transmission"),
                        resultSet.getInt("number_of_forward_gears"),
                        new EngineStatistics(resultSet.getInt("horsepower"),
                                resultSet.getInt("torque"))));
                car.setFuelInformation(new FuelInformation(resultSet.getString("fuel_type"),
                        resultSet.getInt("city_mpg"), resultSet.getInt("highway_mpg")));
                car.setIdentification(new Identification(resultSet.getString("classification"),
                        resultSet.getString("id"), resultSet.getString("make"),
                        resultSet.getString("model_year"), resultSet.getInt("year")));

                myList.add(car);

            }
            System.out.println("--correct find by make cars");
            statement.close();
            return myList;

        } catch(SQLException e) {
            System.out.println("--incorrect find by make cars. " + e.getMessage());
            return null;
        }
    }
}
