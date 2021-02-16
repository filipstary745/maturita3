package Poznamky;

import Databaza.DatabaseCon;
import Kalendar.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;

import java.sql.*;
import java.util.Random;

import static sample1.Controller.Controller.cisloTlacidla;

public class ControllerPoznamka {
    @FXML
    TextArea poznamka;

    @FXML
    public void ulozit() {
        System.out.println("save");
        String localPoznamka = poznamka.getText().trim();

        try {
            Connection connection = DatabaseCon.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = " INSERT INTO POZNAMKA VALUES (" + generator() + ","+ cisloTlacidla +",'" + localPoznamka + "');";
            System.out.println(sql);
            statement.execute(sql);
        } catch (SQLException e) {
        }
    }

    private int generator() {
        Random random = new Random();
        return (random.nextInt(500));
    }
    @FXML
    public void load() {
        String url = "jdbc:h2:tcp://localhost/E:/databaza/maturita.db";
        String name = "filip";
        String pass = "filip";
        try {
            Connection connection = DriverManager.getConnection(url, name, pass);
            Statement statement = connection.createStatement();

            String sql = "SELECT POZNAMKY FROM POZNAMKA where datum =  " + cisloTlacidla +
            " ;";


            ResultSet vystupZDatabazy = statement.executeQuery(sql);

            String zoznamDatabaze = "";
            while (vystupZDatabazy.next()) {


                String meno = vystupZDatabazy.getString("POZNAMKY");

                zoznamDatabaze = zoznamDatabaze +  meno + "" + "\n";

            }
            poznamka.setText(zoznamDatabaze);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}