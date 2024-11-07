package org.exemple.Dao;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8888;
    private static final String DB_NAME = "dl_java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() {

        try{
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s",HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        }catch(SQLException se){
            se.printStackTrace();
        }

        return connection;
    }
}
