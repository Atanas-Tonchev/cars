package com.haemimont.cars.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDataBase implements DataBase {

    @Override
    public Connection connect(String url) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (connection != null) {
            System.out.println("Successfully connected.");
        } else {
            System.out.println("Failed to connect.");
        }

        return connection;
    }

    @Override
    public void disconnect(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
