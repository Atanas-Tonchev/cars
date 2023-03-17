package com.haemimont.cars.database;
import com.haemimont.cars.users.User;
import java.sql.*;


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
        String sql = "SELECT user_name,password FROM csv_cars_db.users WHERE user_name = ? and password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            ResultSet resultSet = statement.executeQuery();
            status = resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    /*public static User loginCheck(Connection connection, User toCheck){

        String sql = "SELECT * FROM csv_cars_db.users WHERE user_name = ?,password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,toCheck.getUsername());
            statement.setString(2,toCheck.getPassword());
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                // if DB returns result, then User is found
                return new User(resultSet.getString("user_name"),resultSet.getString("password"));
            }
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }*/
}
