package com.haemimont.cars;

import com.haemimont.cars.database.DataBase;
import com.haemimont.cars.database.DataBaseUtil;
import com.haemimont.cars.database.MyDataBase;
import com.haemimont.cars.model.Car;
import com.haemimont.cars.storage.Storage;

import java.sql.Connection;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        DataBase dataBase = new MyDataBase();
        String url = "";
        Connection connection = dataBase.connect(url);

        Storage<Object, Car> carStorage = loadCarStorage();

        if (bazataEPrazna) {
            DataBaseUtil.initDB(connection, carStorage);
        }

        ////
        ///
        ///
        ///

        dataBase.disconnect(connection);
    }

    private static Storage<Object, Car> loadCarStorage() {

        return null;
    }
}
