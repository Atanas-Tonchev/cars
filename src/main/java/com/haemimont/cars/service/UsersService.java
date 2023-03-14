package com.haemimont.cars.service;

import com.haemimont.cars.database.UserStatements;
import com.haemimont.cars.users.User;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class UsersService implements CRUDServiceUsers{
    Connection connection = null;

    public UsersService() {
        try {
            connection = ConnectMySqlToTomcat.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean getUser(User user) {
        return UserStatements.validation(user,connection);
    }

    @Override
    public boolean insertUser(User user) {
        return UserStatements.insertUser(user,connection);
    }
}

