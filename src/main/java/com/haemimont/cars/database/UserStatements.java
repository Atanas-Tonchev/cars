package com.haemimont.cars.database;

import com.haemimont.cars.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserStatements {

    public static boolean insertUser(User user, Connection connection) {

        String sql = "INSERT INTO csv_cars_db.users (user_name,password) VALUES (?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2, user.getPassword());
            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
            return rowInserted;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validation(User user,Connection connection){
        boolean status = false;
        String sql = "SELECT * FROM csv_cars_db.users WHERE user_name = ?,password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            ResultSet resultSet = statement.executeQuery();
            status= resultSet.next();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
