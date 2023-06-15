package com.haemimont.cars.database;
import com.haemimont.cars.model.*;
import com.haemimont.cars.utils.SqlBuildingTest;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CarSearchStatements {
    public static List<Car> carsByParam(Connection connection, String make, String yearFrom, String yearTo) {
        List<Car> myList = new ArrayList<>();
        SqlBuildingTest sqlBuildingTest = new SqlBuildingTest();
        PreparedStatement statement;
        ResultSet resultSet;
        int paramIndexStatement = 1;
        Map<Integer, String> map = new HashMap<>();
        try {
            if (make != null && !make.equals("")) {
                sqlBuildingTest.equalsParam("identification.make", make);
                map.put(paramIndexStatement, make);
                paramIndexStatement++;
            }
            if (yearFrom != null && !yearFrom.equals("")) {
                sqlBuildingTest.greatherThanParam("identification.year", yearFrom);
                map.put(paramIndexStatement, yearFrom);
                paramIndexStatement++;
            }
            if (yearTo != null && !yearTo.equals("")) {
                sqlBuildingTest.lessThanParam("identification.year", yearTo);
                map.put(paramIndexStatement, yearTo);
            }
            
            statement = connection.prepareStatement(sqlBuildingTest.getSql());

            for (Map.Entry<Integer,String> entry : map.entrySet()){
                String value = entry.getValue();
                if (value != null) {
                    statement.setString(entry.getKey(), value);
                }
            }
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("car_id");
                int dimH = resultSet.getInt("height");
                int dimL = resultSet.getInt("length");
                int dimW = resultSet.getInt("width");
                String driveLine = resultSet.getString("drive_line");
                String engineType = resultSet.getString("engine_type");
                String hybrid = resultSet.getString("hybrid");
                String transmission = resultSet.getString("transmission");
                int numOfGears = resultSet.getInt("number_of_forward_gears");
                int horsePower = resultSet.getInt("horsepower");
                int torque = resultSet.getInt("torque");
                String fuelType = resultSet.getString("fuel_type");
                int cityMpg = resultSet.getInt("city_mpg");
                int highwayMpg = resultSet.getInt("highway_mpg");
                String classification = resultSet.getString("classification");
                String identificationId = resultSet.getString("id");
                String model = resultSet.getString("make");
                String modelYear = resultSet.getString("model_year");
                int year = resultSet.getInt("year");

                Car car = new Car(new Dimensions(dimH, dimL, dimW), new EngineInformation(driveLine, engineType, hybrid,
                        transmission, numOfGears, new EngineStatistics(horsePower, torque)), new FuelInformation(fuelType,
                        cityMpg, highwayMpg), new Identification(classification, identificationId, model, modelYear, year), id);
                myList.add(car);

            }
            System.out.println("--correct find cars by param");
            statement.close();

        } catch (SQLException e) {
            System.out.println("--incorrect find cars by param. " + e.getMessage());
        }
        return myList;
    }
}
