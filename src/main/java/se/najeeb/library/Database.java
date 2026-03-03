package se.najeeb.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection db = null;

    private Database(){};

    static Connection getConnection(){

        if (db != null) return db;

        String username = "root";
        String password = "rootpassword";
        String host = "localhost";
        String port = "3306";
        String database = "LIBRARY";

        try {
            String url = "jdbc:mysql://" + host + ( port.isBlank() ? "" : ":" + port);
            url += (database.isBlank() ? "/" : "/" + database) + "?useSSL=false";

            db = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return db;
    }
}
