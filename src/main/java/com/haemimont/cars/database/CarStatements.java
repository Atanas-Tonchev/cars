package com.haemimont.cars.database;
import com.haemimont.cars.model.*;

import java.sql.*;
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
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCar, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, insertDimension(car.getDimensions(), connection));
            preparedStatement.setInt(2, insertFuelInformation(car.getFuelInformation(), connection));
            preparedStatement.setInt(3, insertIdentification(car.getIdentification(), connection));
            preparedStatement.setInt(4, insertEngineInformation(car.getEngineInformation(), connection));

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

            statement.setString(1, identification.getClassification());
            statement.setString(2, identification.getID());
            statement.setString(3, identification.getMake());
            statement.setString(4, identification.getModelYear());
            statement.setInt(5, identification.getYear());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
                System.out.println("Table 'Identification' is created with ID: " + result);
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
                "WHERE identification.make = ? ";


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


                for (int i = 0; i < myList.size(); i++) {
                    System.out.println(myList.get(i));

                }


            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return myList;
    }

    /*public static List<Car> getCarsByYear (Connection connection,String year) {
        List<Car> myCars = new ArrayList<>();

        String sqlCarsByYear = "SELECT " +
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
                "WHERE identification.year = ? " ;
                //identification.year = 2009 to 2012

        try {
            PreparedStatement statement = connection.prepareStatement(sqlCarsByYear);
            statement.setString(1, year);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                myCars.add(new Car(new Dimensions((int) resultSet.getObject("height"),
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


                for(int i = 0;i<myCars.size();i++) {
                    System.out.println(myCars.get(i));

                }
                break;
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return myCars;
    }*/

    public static int getLoginID(Connection connection) {
        int id = 0;
        String sqlLogin = "SELECT login_id FROM csv_cars_db.login";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlLogin);

            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }


    public static boolean insertNewCar(Car car, Connection connection) {
        String sql = "INSERT INTO csv_cars_db.dimensions,csv_cars_db.engine_information,csv_cars_db.engine_statistics," +
                "csv_cars_db.fuel_information,csv_cars_db.identification " +
                "(height,length,width,drive_line,engine_type,hybrid,transmission," +
                " number_of_forward_gears,horsepower,torque,fuel_type," +
                "city_mpg,highway_mpg,classification,identification.id,make,model_year,identification.year) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
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

            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
            return rowInserted;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Car> getCars(Connection connection) {

        List<Car> myList = new ArrayList<>();

        String sqlAllCars = "SELECT " +
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
                "ORDER BY car_id DESC LIMIT 5";

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
            resultSet.close();
            statement.close();
            return myList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteCar(Car car, Connection connection) {
        String sqlDelete = "DELETE height,length,width,drive_line,engine_type,hybrid,transmission," +
                "number_of_forward_gears,horsepower,torque,fuel_type," +
                "city_mpg,highway_mpg,classification,identification.id,make,model_year,identification.year" +
                "FROM csv_cars_db.car INNER JOIN csv_cars_db.dimensions " +
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
        ;

        try {
            PreparedStatement statement = connection.prepareStatement(sqlDelete);
            statement.setInt(1, car.getId());

            boolean rowDeleted = statement.executeUpdate() > 0;
            statement.close();
            connection.close();

            return rowDeleted;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean updateCar(Car car, Connection connection) {
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

            boolean rowUpdate = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
            return rowUpdate;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Car getCarByID(Connection connection, int id) {
        Car car = null;
        String sqlCarsById = "SELECT " +
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
                "WHERE car.car_id = ?";


        try {
            PreparedStatement statement = connection.prepareStatement(sqlCarsById);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
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

                car = new Car(new Dimensions(dimH, dimL, dimW), new EngineInformation(driveLine, engineType, hybrid,
                        transmission, numOfGears, new EngineStatistics(horsePower, torque)), new FuelInformation(fuelType,
                        cityMpg, highwayMpg), new Identification(classification, identificationId, make, modelYear, year), id);

                resultSet.close();
                statement.close();


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return car;
    }

    public static List<Car> getLastCarsInserted(Connection connection) {

        List<Car> myList = new ArrayList<>();

        String sqlLastCar = "SELECT " +
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
                "ORDER BY car_id DESC LIMIT 1;";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlLastCar);

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
            resultSet.close();
            statement.close();
            return myList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
