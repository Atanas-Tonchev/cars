package com.haemimont.cars.database;
import com.haemimont.cars.model.Car;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

public class DataBaseUtil {

    public static boolean initDB(Connection connection, Map<Object, Car> carMap) {
        boolean isEmpty = false;

        for (Map.Entry<Object, Car> carEntry : carMap.entrySet()) {

            CarStatements.insertCar(carEntry.getValue(), connection);

        }

        return isEmpty;
    }

    public static boolean selectDB (Connection connection) {
        boolean noData = false;

            CarStatements.selectDB(connection);

        return noData;
    }
}

