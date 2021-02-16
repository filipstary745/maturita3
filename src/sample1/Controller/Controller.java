package sample1.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;


public class Controller {
    public static int cisloTlacidla = 0;

    @FXML
    public void poznamka(javafx.event.ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
        Integer cislo = Integer.parseInt(button.getText());
        cisloTlacidla = cislo;

        URL url = new File("src/Poznamky/SamplePoznamka.fxml").toURI().toURL();
        Parent root;
        try {
            root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setTitle("Poznamka");
            stage.setScene(new Scene(root, 200, 100));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void datum(javafx.event.ActionEvent event) {
        LocalDate currentdate = LocalDate.now();
        System.out.println("Current date: " + currentdate);
        int currentDay = currentdate.getDayOfMonth();
        System.out.println("Current day: " + currentDay);
        Month currentMonth = currentdate.getMonth();
        System.out.println("Current month: " + currentMonth);
        int currentYear = currentdate.getYear();
        System.out.println("Current month: " + currentYear);
    }

    public void close() {
        JFrame frame = new JFrame("EXIT");
            if (JOptionPane.showConfirmDialog(frame, "Confirm if you want Exit", "EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
              System.exit(0);
        }

    }
}
