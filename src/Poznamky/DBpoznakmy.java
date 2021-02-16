package Poznamky;

import Databaza.DatabaseCon;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBpoznakmy {
    public static void main(String[] args) {

        try{

            Connection connection = DatabaseCon.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE POZNAMKA " +
                    "(id INTEGER not NULL, " +
                    " Datum INTEGER, " +
                    " poznamky VARCHAR(255), " +
                    " PRIMARY KEY ( id ));";
            statement.execute(sql);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
