package com.haemimont.cars.database;
import com.haemimont.cars.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarStatements {


    public static int insertCar(Car car, Connection connection) {

        int result = 0;

        String sqlCar = "INSERT INTO csv_cars_db.car (dimensions_dimensions_id," +
                "fuel_information_fuel_information_id," +
                "identification_identification_id," +
                "engine_information_engine_information_id) " +
                "VALUES(?,?,?,?)";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCar,PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1,insertDimension(car.getDimensions(),connection));
            preparedStatement.setInt(2,insertFuelInformation(car.getFuelInformation(),connection));
            preparedStatement.setInt(3,insertIdentification(car.getIdentification(),connection));
            preparedStatement.setInt(4,insertEngineInformation(car.getEngineInformation(),connection));

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
                System.out.println("Tale 'Car' is created with ID: " + result);
            }

            preparedStatement.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }

    public static int insertEngineStatic(EngineStatistics engineStatistics, Connection connection) {
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
            }

            statement.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return result;
    }

    public static int insertIdentification(Identification identification, Connection connection) {
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
            }

            statement.close();

        }catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }

    public static int insertFuelInformation(FuelInformation fuelInformation, Connection connection) {
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
            }

            statement.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }

    public static int insertEngineInformation(EngineInformation engineInformation, Connection connection)  {
        int result = 0;

        String sqlEngineInformation = "INSERT INTO csv_cars_db.engine_information (drive_line,engine_type,hybrid," +
                "transmission,number_of_forward_gears, engine_statistics_engine_statistics_id)" +
                " VALUES( ?,?,?,?,?,? )";

        try {

            PreparedStatement statement = connection.prepareStatement(sqlEngineInformation,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, engineInformation.getDriveLine());
            statement.setString(2, engineInformation.getEngineType());
            statement.setString(3, engineInformation.getHybrid());
            statement.setString(4, engineInformation.getTransmission());
            statement.setInt(5, engineInformation.getNumberOfForwardGears());
            statement.setInt(6,insertEngineStatic(engineInformation.getEngineStatistics(),connection));

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
                System.out.println("Table 'Engine Information' is created with ID: " + result);

            } else {
                System.out.println("No data inserted.");
            }

            statement.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }

    public static int insertDimension(Dimensions dimensions, Connection connection) {
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
            }

            statement.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return result;
    }

    public static List<Car> getCarsByMake(Connection connection, String make) {
        List<Car> myList = new ArrayList<>();

        String sqlAudi = "SELECT " +
                "height,length,width,drive_line,engine_type,hybrid,transmission," +
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
                "WHERE " +
                "identification.make = ? " ;



        try {
            PreparedStatement statement = connection.prepareStatement(sqlAudi);
            statement.setString(1, make);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                myList.add(new Car(new Dimensions((int) resultSet.getObject("height"),
                        (int) resultSet.getObject("length"),
                        (int) resultSet.getObject("width")),
                        new EngineInformation((String) resultSet.getObject("drive_line"),
                                (String) resultSet.getObject("engine_type"),
                                (String) resultSet.getObject("hybrid"),
                                (String) resultSet.getObject("transmission"),
                                (Integer) resultSet.getObject("number_of_forward_gears"),
                                new EngineStatistics((Integer) resultSet.getObject("horsepower"),
                                        (Integer) resultSet.getObject("torque"))),
                        new FuelInformation((String) resultSet.getObject("fuel_type"),
                                (Integer) resultSet.getObject("city_mpg"),
                                (Integer) resultSet.getObject("highway_mpg")),
                        new Identification((String) resultSet.getObject("classification"),
                        (String) resultSet.getObject("identification.id"),
                                (String) resultSet.getObject("make"),
                        (String) resultSet.getObject("model_year"),
                                (Integer) resultSet.getObject("year"))));

               // System.out.println(myList);
                 for(int i = 0;i<myList.size();i++) {
                     System.out.println(myList.get(i));

                }

                break;


              /*  System.out.println("All cars Audi: "+ "\n" +
                        "Dimension Height: " +resultSet.getObject("height")+
                        ", Dimension Length: " +resultSet.getObject("length")+
                        ", Dimension Width: " +resultSet.getObject("width")+
                        ", Engine Information Drive Line: " +resultSet.getObject("drive_line")+
                        ", Engine Information Engine Type: " +resultSet.getObject("engine_type")+
                        ", Engine Information Hybrid: " +resultSet.getObject("hybrid")+
                        ", Engine Information Transmission: " +resultSet.getObject("transmission")+
                        ", Engine Information Number of Forward Gear: " +resultSet.getObject("number_of_forward_gears")+
                        ", Engine Statistics Horsepower: " +resultSet.getObject("horsepower")+
                        ", Engine Statistics Torque: " +resultSet.getObject("torque")+
                        ", Fuel Information Fuel Type: " +resultSet.getObject("fuel_type")+
                        ", Fuel Information City Mpg: " +resultSet.getObject("city_mpg")+
                        ", Fuel Information Highway Mpg: " +resultSet.getObject("highway_mpg")+
                        ", Identification Classification: " +resultSet.getObject("classification")+
                        ", Identification ID: " +resultSet.getObject("identification.id")+
                        ", Identification Make: " +resultSet.getObject("make")+
                        ", Identification Model Year: " +resultSet.getObject("model_year")+
                        ", Identification Year: " +resultSet.getObject("year")); */

            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return myList;
    }

}
