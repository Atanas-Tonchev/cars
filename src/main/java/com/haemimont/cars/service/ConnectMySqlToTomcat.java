package com.haemimont.cars.service;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectMySqlToTomcat {

    public Connection getConnection() throws NamingException, SQLException {

        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/csv_cars_db");
        return ds.getConnection();
    }

}

