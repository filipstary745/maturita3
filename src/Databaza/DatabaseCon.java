package Databaza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCon {
    private String DB_URL = "jdbc:h2:tcp://localhost/E:/databaza/maturita.db";
    private String USER = "filip";
    private String PASS = "filip";

    private void DatabaseCon(){

    }

    private static DatabaseCon databaseCon = null;

    public static DatabaseCon getInstance() {

        if (databaseCon == null) {
            return new DatabaseCon();

        } else {
            return databaseCon;
        }
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }


}
