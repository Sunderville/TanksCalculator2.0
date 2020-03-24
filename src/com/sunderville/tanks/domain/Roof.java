package com.sunderville.tanks.domain;

import com.sunderville.tanks.config.Config;

public class Roof {

    private String roofThikness;

    public Roof(String roofThikness) {
        this.roofThikness = roofThikness;
    }


    public double calculateActualRoofMass(Roof roof, Shell shell) {
        double roofMass = 0;
        Checkings checkings = new Checkings();

        int localRoofThikness;
        if(roof.getRoofThikness().equals("")) {
            localRoofThikness = 0;
        }
        else localRoofThikness = Integer.parseInt(roof.getRoofThikness());

        switch (checkings.defineTankType(shell)) {
            case "РВС-50":
                roofMass = Double.parseDouble(Config.getProp("roof50")) / 4 * localRoofThikness;
                break;
            case "РВС-100":
                roofMass = Double.parseDouble(Config.getProp("roof100")) / 4 * localRoofThikness;
                break;
            case "РВС-200":
                roofMass = Double.parseDouble(Config.getProp("roof200")) / 4 * localRoofThikness;
                break;
            case "РВС-300":
                roofMass = Double.parseDouble(Config.getProp("roof300")) / 5 * localRoofThikness;
                break;
            case "РВС-400":
                roofMass = Double.parseDouble(Config.getProp("roof400")) / 5 * localRoofThikness;
                break;
            case "РВС-500":
                roofMass = Double.parseDouble(Config.getProp("roof500")) / 5 * localRoofThikness;
                break;
            case "РВС-700":
                roofMass = Double.parseDouble(Config.getProp("roof700")) / 5 * localRoofThikness;
                break;
            case "РВС-1000":
                roofMass = Double.parseDouble(Config.getProp("roof1000")) / 6 * localRoofThikness;
                break;
            case "РВС-2000":
                roofMass = Double.parseDouble(Config.getProp("roof2000")) / 4 * localRoofThikness;
                break;
            case "РВС-3000":
                roofMass = Double.parseDouble(Config.getProp("roof3000")) / 4 * localRoofThikness;
                break;
            case "РВС-5000-12":
                roofMass = Double.parseDouble(Config.getProp("roof5000_12")) / 4 * localRoofThikness;
                break;
            case "РВС-5000-15":
                roofMass = Double.parseDouble(Config.getProp("roof5000_15")) / 4 * localRoofThikness;
                break;
            case "РВС-10000-12":
                roofMass = Double.parseDouble(Config.getProp("roof10000_12")) / 4 * localRoofThikness;
                break;
            case "РВС-10000-18":
                roofMass = Double.parseDouble(Config.getProp("roof10000_18")) / 4 * localRoofThikness;
                break;
            case "РВС-20000":
                roofMass = Double.parseDouble(Config.getProp("roof20000")) / 5 * localRoofThikness;
                break;
            case "РВС-30000":
                roofMass = Double.parseDouble(Config.getProp("roof30000")) / 5 * localRoofThikness;
                break;
            case "РВС-50000":
                roofMass = Double.parseDouble(Config.getProp("roof50000")) / 5 * localRoofThikness;
                break;
        }
        return roofMass;
    }

    public String getRoofThikness() {
        return roofThikness;
    }

    public void setRoofThikness(String roofThikness) {
        this.roofThikness = roofThikness;
    }
}
