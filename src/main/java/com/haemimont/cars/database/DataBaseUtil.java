package com.haemimont.cars.database;
import com.haemimont.cars.model.Car;
import java.sql.Connection;
import java.util.Map;
import java.util.Scanner;

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

        Scanner myYear = new Scanner(System.in);
        System.out.println("Enter year from 2009 to 2012: ");
        int year = myYear.nextInt();
        if (year <= 2012 & year >= 2009) {
            switch (year) {
                default:
                    System.out.println("All cars from this years are: " + year);
                    break;
            }
        }else {
            System.out.println("Incorrect year chosen.");
        }

       // String make = "Audi";
            CarStatements.getCarsByYear(connection, String.valueOf(year));
         //CarStatements.getCarsByMake(connection,make);

        return noData;
    }
}

