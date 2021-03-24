package sample1.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;


public class Controller {
    @FXML
    Label po;

    @FXML
    Label ut;

    @FXML
    Label str;

    @FXML
    Label stv;

    @FXML
    Label pa;

    @FXML
    Label so;

    @FXML
    Label ne;

    @FXML
    Button _31;

    @FXML
    Label aktualnyMesiac;

    List<String> pondelok = Arrays.asList("po", "ut", "str", "stv", "pia", "so", "ne");

    List<String> utorok = Arrays.asList("ut", "str", "stv", "pia", "so", "ne", "po");

    List<String> streda = Arrays.asList("str", "stv", "pia", "so", "ne", "po", "ut");

    List<String> stvrtor = Arrays.asList("stv", "pia", "so", "ne", "po", "ut", "str");

    List<String> piatok = Arrays.asList("pia", "so", "ne", "po", "ut", "str", "stv");

    List<String> sobota = Arrays.asList("so", "ne", "po", "ut", "str", "stv", "pia");

    List<String> nedela = Arrays.asList("ne", "po", "ut", "str", "stv", "pia", "so");


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


    /*public void initialize() {
        //datum.setText("filip");
        LocalDate currentdate = LocalDate.now();
        Month currentMonth = currentdate.getMonth();
        System.out.println("Current month: " + currentMonth);
        int currentYear = currentdate.getYear();
        System.out.println("Current month: " + currentYear);
     //   datum.setText("" + currentMonth + " " + currentYear);

    }
*/


    public void close() {
        JFrame frame = new JFrame("EXIT");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want Exit", "EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }


    }
    @FXML
    int aktualnyMesiacInt=0;
    @FXML
    public void zmenaTyzdna(){

        int tyzden=getDayNumberNew(firstDayOfMonth(aktualnyMesiacInt));

        switch (tyzden){

            case 1:
                setLables(pondelok);
                break;
            case 2:
                setLables(utorok);
                break;
            case 3:
                setLables(streda);
                break;
            case 4:
                setLables(stvrtor);
                break;
            case 5:
                setLables(pondelok);
                break;
            case 6:
                setLables(pondelok);
                break;
            case 7:
                setLables(pondelok);
                break;
        }



    }
    public  int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }


    public LocalDate firstDayOfMonth(int plusMonth) {
        LocalDate todaydate = LocalDate.now().plusMonths(plusMonth);
        //System.out.println("Months first date in yyyy-mm-dd: " + todaydate.withDayOfMonth(1));
        return todaydate.withDayOfMonth(1);

    }
    public void setLables(List<String> weeks){

        po.setText(weeks.get(0));
        ut.setText(weeks.get(1));
        str.setText(weeks.get(2));
        stv.setText(weeks.get(3));
        pa.setText(weeks.get(4));
        so.setText(weeks.get(5));
        ne.setText(weeks.get(6));

    }
    public void initialize(){
        aktualnyMesiac.setText(LocalDate.now().getMonth().toString());
        zmenaTyzdna();
  //      _31.setVisible(false);
    }
    @FXML
    public void zmenaMesiac(){
        aktualnyMesiacInt++;
        aktualnyMesiac.setText(LocalDate.now().plusMonths(aktualnyMesiacInt).getMonth().toString());

        zmenaTyzdna();



    }
}
