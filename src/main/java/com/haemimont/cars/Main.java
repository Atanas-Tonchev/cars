package com.haemimont.cars;

import com.haemimont.cars.database.DataBase;
import com.haemimont.cars.database.DataBaseUtil;
import com.haemimont.cars.database.MyDataBase;
import com.haemimont.cars.model.Car;
import com.haemimont.cars.storage.Storage;
import com.haemimont.cars.util.Util;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.Connection;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        DataBase dataBase = new MyDataBase();
        String url = "";
        Connection connection = dataBase.connect(url);

        boolean isDatabaseEmpty = true;

        Storage<Object, Car> carStorage = Util.loadCarStorage("file.csv");

        if (isDatabaseEmpty) {
            DataBaseUtil.initDB(connection, carStorage);
        }

        dataBase.disconnect(connection);
    }

}
