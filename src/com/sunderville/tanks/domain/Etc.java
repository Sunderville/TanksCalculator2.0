package com.sunderville.tanks.domain;

import com.sunderville.tanks.config.Config;

public class Etc {

    private String insulationWeight;
    private String heaterWeight;
    private String otherWeight1;
    private String otherWeight2;
    private String otherWeight1Name;
    private String otherWeight2Name;

    public Etc(String insulationWeightText, String heaterWeight, String otherWeight1, String otherWeight2, String otherWeight1Name, String otherWeight2Name) {
        this.insulationWeight = insulationWeightText;
        this.heaterWeight = heaterWeight;
        this.otherWeight1 = otherWeight1;
        this.otherWeight2 = otherWeight2;
        this.otherWeight1Name = otherWeight1Name;
        this.otherWeight2Name = otherWeight2Name;
    }

    public double calculateEtcMass(Etc etc, Shell shell) {
        double heaterWeight = etc.getHeaterWeight().equals("") ?
                0.0 : Double.parseDouble(etc.getHeaterWeight());
        double insulationWeight = etc.getInsulationWeight().equals("") ?
                0.0 : Double.parseDouble(etc.getInsulationWeight());
        double otherWeight1 = etc.getOtherWeight1().equals("") ?
                0.0 : Double.parseDouble(etc.getOtherWeight1());
        double otherWeight2 = etc.getOtherWeight2().equals("") ?
                0.0 : Double.parseDouble(etc.getOtherWeight2());
        return defineBasicEtcMass(shell) + heaterWeight + insulationWeight + otherWeight1 + otherWeight2;
    }

    private double defineBasicEtcMass(Shell shell) {
        String etcMass = "0";
        Checkings checkings = new Checkings();

        switch (checkings.defineTankType(shell)) {
            case "РВС-50":
                etcMass = Config.getProp("etc50");
                break;
            case "РВС-100":
                etcMass = Config.getProp("etc100");
                break;
            case "РВС-200":
                etcMass = Config.getProp("etc200");
                break;
            case "РВС-300":
                etcMass = Config.getProp("etc300");
                break;
            case "РВС-400":
                etcMass = Config.getProp("etc400");
                break;
            case "РВС-500":
                etcMass = Config.getProp("etc500");
                break;
            case "РВС-700":
                etcMass = Config.getProp("etc700");
                break;
            case "РВС-1000":
                etcMass = Config.getProp("etc1000");
                break;
            case "РВС-2000":
                etcMass = Config.getProp("etc2000");
                break;
            case "РВС-3000":
                etcMass = Config.getProp("etc3000");
                break;
            case "РВС-5000-12":
                etcMass = Config.getProp("etc5000_12");
                break;
            case "РВС-5000-15":
                etcMass = Config.getProp("etc5000_15");
                break;
            case "РВС-10000-12":
                etcMass = Config.getProp("etc10000_12");
                break;
            case "РВС-10000-18":
                etcMass = Config.getProp("etc10000_18");
                break;
            case "РВС-20000":
                etcMass = Config.getProp("etc20000");
                break;
            case "РВС-30000":
                etcMass = Config.getProp("etc30000");
                break;
            case "РВС-50000":
                etcMass = Config.getProp("etc50000");
                break;
        }
        return Double.parseDouble(etcMass);
    }


    public String getInsulationWeight() {
        return insulationWeight;
    }

    public void setInsulationWeight(String insulationWeight) {
        this.insulationWeight = insulationWeight;
    }

    public String getHeaterWeight() {
        return heaterWeight;
    }

    public void setHeaterWeight(String heaterWeight) {
        this.heaterWeight = heaterWeight;
    }

    public String getOtherWeight1() {
        return otherWeight1;
    }

    public void setOtherWeight1(String otherWeight1) {
        this.otherWeight1 = otherWeight1;
    }

    public String getOtherWeight2() {
        return otherWeight2;
    }

    public void setOtherWeight2(String otherWeight2) {
        this.otherWeight2 = otherWeight2;
    }

    public String getOtherWeight1Name() {
        return otherWeight1Name;
    }

    public void setOtherWeight1Name(String otherWeight1Name) {
        this.otherWeight1Name = otherWeight1Name;
    }

    public String getOtherWeight2Name() {
        return otherWeight2Name;
    }

    public void setOtherWeight2Name(String otherWeight2Name) {
        this.otherWeight2Name = otherWeight2Name;
    }
}
