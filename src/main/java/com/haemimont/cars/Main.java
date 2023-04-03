package com.haemimont.cars;
import com.haemimont.cars.database.DataBase;
import com.haemimont.cars.database.MyDataBase;

import com.haemimont.cars.service.CRUDServiceUsers;
import com.haemimont.cars.service.UsersService;

import java.sql.Connection;



public class Main {

    public static void main(String[] args) {
        DataBase dataBase = new MyDataBase();
        String url = "jdbc:mysql://root:nasko@localhost:3306/csv_cars_db";
        Connection connection = dataBase.connect(url);

    }
}
