package com.haemimont.cars.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBase {

    Connection connect(String url);

    void disconnect(Connection connection);

}
