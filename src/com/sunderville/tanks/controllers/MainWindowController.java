package com.sunderville.tanks.controllers;

import com.sunderville.tanks.animations.Shake;
import com.sunderville.tanks.config.Config;
import com.sunderville.tanks.domain.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController {

    Checkings checkings;
    Tank tank;

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private MenuButton diameter;

    @FXML
    private TextField ring12;
    @FXML
    private TextField ring11;
    @FXML
    private TextField ring10;
    @FXML
    private TextField ring9;
    @FXML
    private TextField ring8;
    @FXML
    private TextField ring7;
    @FXML
    private TextField ring6;
    @FXML
    private TextField ring5;
    @FXML
    private TextField ring4;
    @FXML
    private TextField ring3;
    @FXML
    private TextField ring2;
    @FXML
    private TextField ring1;
    @FXML
    private TextField bottom_center_thikness;
    @FXML
    private TextField bottom_rim_thikness;
    @FXML
    private TextField roof_thikness;
    @FXML
    private TextField insulation_weight;
    @FXML
    private TextField heater_weight;
    @FXML
    private TextField other_weight1;
    @FXML
    private TextField other_weight2;
    @FXML
    private TextField other_weight1_name;
    @FXML
    private TextField other_weight2_name;

    @FXML
    public MenuButton steel_type;
    @FXML
    private TextField result_mass;
    @FXML
    private TextField ton_price;
    @FXML
    private TextField result_price;

    @FXML
    private Button log_button;
    @FXML
    private Button calculate_button;
    @FXML
    private Button information_button;

    @FXML
    void d45600s(ActionEvent event) {
        tank.setDiameter(45600);
        diameter.setText("45600");
    }
    @FXML
    void d3800s(ActionEvent event) {
        tank.setDiameter(3800);
        diameter.setText("3800");
    }
    @FXML
    void d4730s(ActionEvent event) {
        tank.setDiameter(4730);
        diameter.setText("4730");
    }
    @FXML
    void d6630s(ActionEvent event) {
        tank.setDiameter(6630);
        diameter.setText("6630");
    }
    @FXML
    void d7580s(ActionEvent event) {
        tank.setDiameter(7580);
        diameter.setText("7580");
    }
    @FXML
    void d8530s(ActionEvent event) {
        tank.setDiameter(8530);
        diameter.setText("8530");
    }
    @FXML
    void d10430s(ActionEvent event) {
        tank.setDiameter(10430);
        diameter.setText("10430");
    }
    @FXML
    void d15180s(ActionEvent event) {
        tank.setDiameter(15180);
        diameter.setText("15180");
    }
    @FXML
    void d18980s(ActionEvent event) {
        tank.setDiameter(18980);
        diameter.setText("18980");
    }
    @FXML
    void d20920s(ActionEvent event) {
        tank.setDiameter(20920);
        diameter.setText("20920");
    }
    @FXML
    void d22800s(ActionEvent event) {
        tank.setDiameter(22800);
        diameter.setText("22800");
    }
    @FXML
    void d28500s(ActionEvent event) {
        tank.setDiameter(28500);
        diameter.setText("28500");
    }
    @FXML
    void d34200s(ActionEvent event) {
        tank.setDiameter(34200);
        diameter.setText("34200");
    }
    @FXML
    void d39900s(ActionEvent event) {
        tank.setDiameter(39900);
        diameter.setText("39900");
    }
    @FXML
    void d60700s(ActionEvent event) {
        tank.setDiameter(60700);
        diameter.setText("60700");
    }

    @FXML
    void sSt3selected(ActionEvent event) {
        tank.setDensity(Double.parseDouble(Config.getProp("st3sp")));
        steel_type.setText("Ст3сп");
    }
    @FXML
    void s09selected(ActionEvent event) {
        tank.setDensity(Double.parseDouble(Config.getProp("09g2s")));
        steel_type.setText("09Г2С");
    }
    @FXML
    void s12selected(ActionEvent event) {
        tank.setDensity(Double.parseDouble(Config.getProp("12h18n10t")));
        steel_type.setText("12Х18Н10Т");
    }

    @FXML
    void informationButtonPressed(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/sunderville/tanks/fxml/Information.fxml"));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void calculateButtonPressed(MouseEvent event) {
        if(!diameter.getText().equals("Выберите диаметр")){
            Roof roof = new Roof(roof_thikness.getText());
            Shell shell = new Shell(diameter.getText(),
                    ring1.getText(), ring2.getText(), ring3.getText(), ring4.getText(),
                    ring5.getText(), ring6.getText(), ring7.getText(), ring8.getText(),
                    ring9.getText(), ring10.getText(), ring11.getText(), ring12.getText());
            Bottom bottom = new Bottom(diameter.getText(), bottom_rim_thikness.getText(), bottom_center_thikness.getText());
            Etc etc = new Etc(insulation_weight.getText(), heater_weight.getText(),
                    other_weight1_name.getText(), other_weight1.getText(),
                    other_weight2_name.getText(), other_weight2.getText());

            tank.setRoof(roof);
            tank.setShell(shell);
            tank.setBottom(bottom);
            tank.setEtc(etc);

            result_mass.setText(String.valueOf(tank.resultMass(tank)));
            result_price.setText(String.valueOf(tank.resultPrice(tank, ton_price.getText())));

        } else {
            Shake shake = new Shake(diameter);
            shake.playShake();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/sunderville/tanks/fxml/SelectDiameter.fxml"));

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void logButtonPressed(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/sunderville/tanks/fxml/FormToFill.fxml"));
        fxmlLoader.setController(new FormToFill(tank, String.valueOf(steel_type.getText())));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }


    @FXML
    void initialize() {
        checkings = new Checkings();
        tank = new Tank();
        steel_type.setText("Ст3сп");
        tank.setDensity(Double.parseDouble(Config.getProp("st3sp")));

    }
}
