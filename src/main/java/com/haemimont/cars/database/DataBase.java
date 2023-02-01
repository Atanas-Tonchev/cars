package com.haemimont.cars.database;

import java.sql.Connection;


public interface DataBase {

    Connection connect(String url);

    void disconnect(Connection connection);

}
