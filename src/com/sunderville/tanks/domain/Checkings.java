package com.sunderville.tanks.domain;

import com.sunderville.tanks.exceptions.DefineTankTypeException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Checkings {





    public String defineTankType(Shell shell) {
        String type = "";
        if(shell.getDiameter().equals("3800") && ringsNumber(shell) == 3) type = "РВС-50";
        else if(shell.getDiameter().equals("4730") && ringsNumber(shell) == 4) type = "РВС-100";
        else if(shell.getDiameter().equals("6630") && ringsNumber(shell) == 4) type = "РВС-200";
        else if(shell.getDiameter().equals("7580") && ringsNumber(shell) == 5) type = "РВС-300";
        else if(shell.getDiameter().equals("8530") && ringsNumber(shell) == 5) type = "РВС-400";
        else if(shell.getDiameter().equals("8530") && ringsNumber(shell) == 6) type = "РВС-500";
        else if(shell.getDiameter().equals("10430") && ringsNumber(shell) == 6) type = "РВС-700";
        else if(shell.getDiameter().equals("10430") && ringsNumber(shell) == 8) type = "РВС-1000";
        else if(shell.getDiameter().equals("15180") && ringsNumber(shell) == 8) type = "РВС-2000";
        else if(shell.getDiameter().equals("18980") && ringsNumber(shell) == 8) type = "РВС-3000";
        else if(shell.getDiameter().equals("20920") && ringsNumber(shell) == 10) type = "РВС-5000-15";
        else if(shell.getDiameter().equals("22800") && ringsNumber(shell) == 8) type = "РВС-5000-12";
        else if(shell.getDiameter().equals("28500") && ringsNumber(shell) == 12) type = "РВС-10000-12";
        else if(shell.getDiameter().equals("34200") && ringsNumber(shell) == 8) type = "РВС-10000-18";
        else if(shell.getDiameter().equals("39900") && ringsNumber(shell) == 12) type = "РВС-20000";
        else if(shell.getDiameter().equals("45600") && ringsNumber(shell) == 12) type = "РВС-30000";
        else if(shell.getDiameter().equals("60700") && ringsNumber(shell) == 12) type = "РВС-50000";
        else try {
                diamRingDiscrep();
                throw new DefineTankTypeException("Несоответствие диаметра и количества поясов. Проверьте введённые данные");
            } catch (DefineTankTypeException e) {
                e.printStackTrace();
            }
        return type;
    }

    private int ringsNumber(Shell shell) {
        int number = 0;
        if(!shell.getRing1().equals("")) number++;
        if(!shell.getRing2().equals("")) number++;
        if(!shell.getRing3().equals("")) number++;
        if(!shell.getRing4().equals("")) number++;
        if(!shell.getRing5().equals("")) number++;
        if(!shell.getRing6().equals("")) number++;
        if(!shell.getRing7().equals("")) number++;
        if(!shell.getRing8().equals("")) number++;
        if(!shell.getRing9().equals("")) number++;
        if(!shell.getRing10().equals("")) number++;
        if(!shell.getRing11().equals("")) number++;
        if(!shell.getRing12().equals("")) number++;
        return number;
    }

    private void diamRingDiscrep() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/sunderville/tanks/fxml/DiamRingsDiscrepancy.fxml"));
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

        throw new RuntimeException("");

    }

}
