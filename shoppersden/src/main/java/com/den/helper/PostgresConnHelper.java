package com.den.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PostgresConnHelper {
    private static ResourceBundle resourceBundle;
    private static Connection conn;
    public static Connection getConnection(){
        //resource bundle reads property file. Name is db.properties
        resourceBundle=ResourceBundle.getBundle("db");
        String userName=resourceBundle.getString("username");
        String password=resourceBundle.getString("password");
        String url=resourceBundle.getString("url");

        try {
            conn= DriverManager.getConnection(url,userName,password);
        } catch (SQLException exception) {
              System.out.println(exception.getMessage());
        }
        return conn;
    }
}
