package com.haemimont.cars;
import com.haemimont.cars.database.DataBase;
import com.haemimont.cars.database.DataBaseUtil;
import com.haemimont.cars.database.MyDataBase;
import com.haemimont.cars.model.Car;
import com.haemimont.cars.storage.Storage;
import com.haemimont.cars.util.Util;
import java.sql.Connection;


public class Main {

    public static void main(String[] args) {
        DataBase dataBase = new MyDataBase();
        String url = "jdbc:mysql://root:nasko@localhost:3306/csv_cars_db";
        Connection connection = dataBase.connect(url);

        boolean isDatabaseEmpty = true;

        Storage<Object, Car> carStorage = Util.loadCarStorage("C:\\Users\\User\\IdeaProjects\\git\\cars\\data\\cars.csv");


        if (isDatabaseEmpty) {
            DataBaseUtil.initDB(connection, carStorage);
        }

        dataBase.disconnect(connection);
    }

}
