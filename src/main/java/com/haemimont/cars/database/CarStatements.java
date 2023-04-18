package com.haemimont.cars.database;
import com.haemimont.cars.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CarStatements {


    public static void insert(Car car, Connection connection) {



        String sqlCar = "INSERT INTO csv_cars_db.car (dimensions_dimensions_id," +
                "fuel_information_fuel_information_id," +
                "identification_identification_id," +
                "engine_information_engine_information_id) " +
                "VALUES(?,?,?,?)";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCar, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, insertDimension(car.getDimensions(), connection));
            preparedStatement.setInt(2, insertFuelInformation(car.getFuelInformation(), connection));
            preparedStatement.setInt(3, insertIdentification(car.getIdentification(), connection));
            preparedStatement.setInt(4, insertEngineInformation(car.getEngineInformation(), connection));

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                resultSet.getInt(1);
                System.out.println("--correct insert Car in database.");
            }else {
                System.out.println("No data inserted.");
            }
            preparedStatement.close();

        } catch (Exception e) {
            System.out.println("--incorrect insert Car in database. " + e.getMessage());
            throw new RuntimeException();
        }

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

            statement.setString(1, identification.getClassification());
            statement.setString(2, identification.getID());
            statement.setString(3, identification.getMake());
            statement.setString(4, identification.getModelYear());
            statement.setInt(5, identification.getYear());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            } else {
                System.out.println("No data inserted.");
            }

            statement.close();


        } catch (Exception e) {
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

    public static int insertEngineInformation(EngineInformation engineInformation, Connection connection) {
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
            statement.setInt(6, insertEngineStatic(engineInformation.getEngineStatistics(), connection));

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                result = resultSet.getInt(1);

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

    public static List<String> allModels(Connection connection){
        List<String> list = new ArrayList<>();

        String sqlModels = "select distinct make from csv_cars_db.identification order by make";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlModels);

            while (resultSet.next()) {
                list.add(resultSet.getString("make"));

            }
            System.out.println("--correct find car by make");
            statement.close();
            return list;


        } catch (SQLException e) {
            System.out.println("--incorrect find car. " + e.getMessage());
            throw new RuntimeException(e);

        }
    }

    public static List<Car> allCars(Connection connection) {

        List<Car> myList = new ArrayList<>();

        String sqlAllCars = "(SELECT " +
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
                "ORDER BY car_id ASC LIMIT 9)" +
                "UNION" +
                "(SELECT car_id,height,length,width,drive_line,engine_type,hybrid,transmission," +
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
                "ORDER BY car_id DESC LIMIT 5)" ;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlAllCars);

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
                String make = resultSet.getString("make");
                String modelYear = resultSet.getString("model_year");
                int year = resultSet.getInt("year");

                Car car = new Car(new Dimensions(dimH, dimL, dimW), new EngineInformation(driveLine, engineType, hybrid,
                        transmission, numOfGears, new EngineStatistics(horsePower, torque)), new FuelInformation(fuelType,
                        cityMpg, highwayMpg), new Identification(classification, identificationId, make, modelYear, year), id);

                myList.add(car);

            }

            statement.close();

            return myList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int carID, Connection connection) {
        String sqlDelete = "DELETE csv_cars_db.car,csv_cars_db.dimensions,csv_cars_db.engine_information," +
                "csv_cars_db.engine_statistics,csv_cars_db.fuel_information,csv_cars_db.identification " +
                "FROM csv_cars_db.car INNER JOIN csv_cars_db.dimensions ON dimensions_id = dimensions_dimensions_id " +
                "INNER JOIN csv_cars_db.engine_information ON engine_information_id = engine_information_engine_information_id " +
                "INNER JOIN csv_cars_db.engine_statistics ON engine_statistics_id = engine_statistics_engine_statistics_id " +
                "INNER JOIN csv_cars_db.fuel_information ON fuel_information_id=fuel_information_fuel_information_id " +
                "INNER JOIN csv_cars_db.identification ON identification_id=identification_identification_id WHERE car.car_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);

            preparedStatement.setInt(1, carID);
            preparedStatement.executeUpdate();

            System.out.println("--correct deleted car");

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("--incorrect deleted car. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void update(Car car, Connection connection) {
        String sqlUpdate = "UPDATE csv_cars_db.car,csv_cars_db.dimensions,csv_cars_db.engine_information," +
                "csv_cars_db.engine_statistics," +
                "csv_cars_db.fuel_information,csv_cars_db.identification" +
                "INNER JOIN " +
                "csv_cars_db.dimensions " +
                "ON dimensions.dimensions_id = car.dimensions_dimensions_id " +
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
                "SET height = ?,length = ?,width = ?,drive_line = ?,engine_type = ?,hybrid = ?,transmission = ?," +
                "number_of_forward_gears = ?,horsepower = ?,torque = ?,fuel_type = ?,city_mpg = ?,highway_mpg = ?," +
                "classification = ?,identification.id = ?,make = ?,model_year = ?,identification.year = ?" +
                " WHERE car.car_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlUpdate);
            statement.setInt(1, car.getDimensions().getHeight());
            statement.setInt(2, car.getDimensions().getLength());
            statement.setInt(3, car.getDimensions().getWidth());
            statement.setString(4, car.getEngineInformation().getDriveLine());
            statement.setString(5, car.getEngineInformation().getEngineType());
            statement.setString(6, car.getEngineInformation().getHybrid());
            statement.setString(7, car.getEngineInformation().getTransmission());
            statement.setInt(8, car.getEngineInformation().getNumberOfForwardGears());
            statement.setInt(9, car.getEngineInformation().getEngineStatistics().getHorsepower());
            statement.setInt(10, car.getEngineInformation().getEngineStatistics().getTorque());
            statement.setString(11, car.getFuelInformation().getFuelType());
            statement.setInt(12, car.getFuelInformation().getCityMpg());
            statement.setInt(13, car.getFuelInformation().getHighwayMpg());
            statement.setString(14, car.getIdentification().getClassification());
            statement.setString(15, car.getIdentification().getID());
            statement.setString(16, car.getIdentification().getMake());
            statement.setString(17, car.getIdentification().getModelYear());
            statement.setInt(18, car.getIdentification().getYear());
            statement.setInt(19,car.getId());

            statement.executeUpdate();
            System.out.println("--correct update on database");

            statement.close();


        } catch (SQLException e) {
            System.out.println("--incorrect update on database. " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static Car carByID(Connection connection, int id) {

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
                "WHERE car.car_id = ?";


        try {
            Car car = new Car();
            PreparedStatement statement = connection.prepareStatement(sqlCarsById);
            statement.setInt(1, id);
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

            }
            System.out.println("--correct find by id cars");
            return car;

        } catch(SQLException e) {
            System.out.println("--incorrect find by id cars. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
