package com.sunderville.tanks.controllers;

import com.sunderville.tanks.domain.Checkings;
import com.sunderville.tanks.domain.Tank;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class FormToFill {

    public MenuItem OOO;
    public MenuItem AO;
    public MenuItem PAO;
    public MenuItem MUP;
    public MenuItem IP;
    public MenuItem individual;
    public MenuItem other_property_form;
    private Tank tank;
    private String steelType;

    public FormToFill() {

    }

    public FormToFill(Tank tank, String steelType) {
        this.tank = tank;
        this.steelType = steelType;
    }

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private Button save_log_button;

    @FXML
    private MenuButton month;
    @FXML
    private MenuButton year;
    @FXML
    private MenuButton form_of_property_menubutton;

    @FXML
    private TextField customer_name;
    @FXML
    private TextField contact_name;
    @FXML
    private TextField phone_number;
    @FXML
    private TextField haul_to;
    @FXML
    private TextField quantity;
    @FXML
    private TextArea comment_field;

    @FXML
    void OOO(ActionEvent event) {
        form_of_property_menubutton.setText("ООО");
    }
    @FXML
    void AO(ActionEvent event) {
        form_of_property_menubutton.setText("АО");
    }
    @FXML
    void PAO(ActionEvent event) {
        form_of_property_menubutton.setText("ПАО");
    }
    @FXML
    void MUP(ActionEvent event) {
        form_of_property_menubutton.setText("МУП");
    }
    @FXML
    void IP(ActionEvent event) {
        form_of_property_menubutton.setText("ИП");
    }
    @FXML
    void individual(ActionEvent event) {
        form_of_property_menubutton.setText("частное лицо");
    }
    @FXML
    void other_property_form(ActionEvent event) {
        form_of_property_menubutton.setText("другая форма собственности");
    }

    @FXML
    void january(ActionEvent event) {
        month.setText("январь");
    }
    @FXML
    void february(ActionEvent event) {
        month.setText("февраль");
    }
    @FXML
    void march(ActionEvent event) {
        month.setText("март");
    }
    @FXML
    void april(ActionEvent event) {
        month.setText("апрель");
    }
    @FXML
    void may(ActionEvent event) {
        month.setText("май");
    }
    @FXML
    void june(ActionEvent event) {
        month.setText("июнь");
    }
    @FXML
    void july(ActionEvent event) {
        month.setText("июль");
    }
    @FXML
    void august(ActionEvent event) {
        month.setText("август");
    }
    @FXML
    void october(ActionEvent event) {
        month.setText("сентябрь");
    }
    @FXML
    void september(ActionEvent event) {
        month.setText("октябрь");
    }
    @FXML
    void november(ActionEvent event) {
        month.setText("ноябрь");
    }
    @FXML
    void december(ActionEvent event) {
        month.setText("декабрь");
    }
    @FXML
    void unknowember(ActionEvent event) {
        month.setText("х/з");
    }

    @FXML
    void year2020(ActionEvent event) {
        year.setText("2020");
    }
    @FXML
    void year2021(ActionEvent event) {
        year.setText("2021");
    }
    @FXML
    void year2022(ActionEvent event) {
        year.setText("2022");
    }
    @FXML
    void year2023(ActionEvent event) {
        year.setText("2023");
    }
    @FXML
    void year2024(ActionEvent event) {
        year.setText("2024");
    }
    @FXML
    void year2025(ActionEvent event) {
        year.setText("2025");
    }
    @FXML
    void year2026(ActionEvent event) {
        year.setText("2026");
    }
    @FXML
    void year2027(ActionEvent event) {
        year.setText("2027");
    }
    @FXML
    void year2028(ActionEvent event) {
        year.setText("2028");
    }
    @FXML
    void year2029(ActionEvent event) {
        year.setText("2029");
    }

    @FXML
    void saveLogButtonPressed(MouseEvent event) {
        saveToFile(compileLog(tank, month, year, form_of_property_menubutton,
                customer_name, contact_name, phone_number, haul_to, quantity, comment_field));
    }



    @FXML
    void initialize() {
//        compileLog(tank);

//TODO Реализовать сохранение
//        print_button();
//        save_log_button();


    }

    public String compileLog(Tank tank,
                             MenuButton month, MenuButton year,
                             MenuButton form_of_property, TextField customer_name,
                             TextField contact_name, TextField phone_number,
                             TextField haul_to, TextField quantity, TextArea comment_field){
        Checkings checkings = new Checkings();
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add(form_of_property.getText());
        stringJoiner.add(customer_name.getText());
        stringJoiner.add("\n");
        stringJoiner.add(contact_name.getText() + "  ");
        stringJoiner.add(phone_number.getText());
        stringJoiner.add("\n");
        stringJoiner.add(checkings.defineTankType(tank.getShell()) + "  ");
        stringJoiner.add(quantity.getText());
        stringJoiner.add(" шт.");
        stringJoiner.add("\nКуда везти: ");
        stringJoiner.add(haul_to.getText());
        stringJoiner.add("\nРеализация запланирована на ");
        stringJoiner.add(month.getText());
        stringJoiner.add(year.getText());
        stringJoiner.add("\n_______________");
        stringJoiner.add("\nКровля: ");
        stringJoiner.add(tank.getRoof().getRoofThikness());
        stringJoiner.add("\n");
        stringJoiner.add("\n12-й пояс: ");
        stringJoiner.add(tank.getShell().getRing12());
        stringJoiner.add("\n11-й пояс: ");
        stringJoiner.add(tank.getShell().getRing11());
        stringJoiner.add("\n10-й пояс: ");
        stringJoiner.add(tank.getShell().getRing10());
        stringJoiner.add("\n9-й пояс:    ");
        stringJoiner.add(tank.getShell().getRing9());
        stringJoiner.add("\n8-й пояс:    ");
        stringJoiner.add(tank.getShell().getRing8());
        stringJoiner.add("\n7-й пояс:    ");
        stringJoiner.add(tank.getShell().getRing7());
        stringJoiner.add("\n6-й пояс:    ");
        stringJoiner.add(tank.getShell().getRing6());
        stringJoiner.add("\n5-й пояс:    ");
        stringJoiner.add(tank.getShell().getRing5());
        stringJoiner.add("\n4-й пояс:    ");
        stringJoiner.add(tank.getShell().getRing4());
        stringJoiner.add("\n3-й пояс:    ");
        stringJoiner.add(tank.getShell().getRing3());
        stringJoiner.add("\n2-й пояс:    ");
        stringJoiner.add(tank.getShell().getRing2());
        stringJoiner.add("\n1-й пояс:    ");
        stringJoiner.add(tank.getShell().getRing1());
        stringJoiner.add("\n");
        stringJoiner.add("\nЦентральная часть днища: ");
        stringJoiner.add(tank.getBottom().getBottomCenterThikness());
        stringJoiner.add("\nОкрайка днища: ");
        stringJoiner.add(tank.getBottom().getBottomRimThikness());
        stringJoiner.add("\n");
        stringJoiner.add("\nВес подогревателя: ");
        stringJoiner.add(tank.getEtc().getHeaterWeight());
        stringJoiner.add("\nВес крепления изоляции: ");
        stringJoiner.add(tank.getEtc().getInsulationWeight());
        stringJoiner.add("\nВес дополнительного элемента - ");
        stringJoiner.add(tank.getEtc().getOtherWeight1Name());
        stringJoiner.add(":  ");
        stringJoiner.add(tank.getEtc().getOtherWeight1());
        stringJoiner.add("\nВес дополнительного элемента - ");
        stringJoiner.add(tank.getEtc().getOtherWeight2Name());
        stringJoiner.add(":  ");
        stringJoiner.add(tank.getEtc().getOtherWeight2());
        stringJoiner.add("\nМарка стали: ");
        stringJoiner.add(steelType);
        stringJoiner.add("\n_______________");
        stringJoiner.add("\nОбщий вес: ");
        stringJoiner.add(String.valueOf(
                tank.resultMass(tank)));
        stringJoiner.add("  т.\n");
        stringJoiner.add("\nКомментарии: \n");
        stringJoiner.add(comment_field.getText());

        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd" + "  " + "hh.mm")) +
                "\n_______________" +
                "\n" + "\n" + stringJoiner;
    }

    private void saveToFile(String text) {
        File log = new File("C:\\tanklog-" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd" + "-" + "hh.mm")) +
                ".doc");
        try {
            boolean created = log.createNewFile();
            if(created)
                System.out.println("File has been created");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        try (FileOutputStream fos = new FileOutputStream(log))
        {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}