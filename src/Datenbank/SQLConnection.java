package Datenbank;


import Chat.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLConnection {

    private String url = "jdbc:mysql://localhost/messages";
    private String username = "root";
    private String password = "HTLbabeldirMEMES!2004!";

    private Connection connection;

    public void SQLConnection() {
        try {
            Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
            if(c != null){
                System.out.println("Der Mysql Treiber wurde geladen!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the driver! " + e);
        }
    }

    public void openConnection() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException exception) {
            System.out.println("Failed to connect " + exception);

        }
    }

    public void closeConnection() {
        try {
            if ((this.connection != null) && (!this.connection.isClosed())) {
                this.connection.close();
                System.out.println("Verbindung wurde geschlossen!");
            }
        } catch (SQLException exception) {
            System.out.println("Failed to close " + exception);
        }
    }


    public boolean insertUserToSql (User user) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("insert into userTable values(?, ?, ?, ?)");

            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());

            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println("An exception in inserting the User to the Database occured! " + e);
        }

        return false;
    }
}