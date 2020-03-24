package com.sunderville.tanks.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tank {

    private Roof roof;
    private Shell shell;
    private Bottom bottom;
    private Etc etc;
    private int diameter;
    private double density;


    public double resultMass(Tank tank) {

        double roofMass = roof.calculateActualRoofMass(tank.getRoof(), tank.getShell());
        double shellVolume = shell.calculateShellVolume(tank.getShell());
        double bottomVolume = bottom.calculateBottomVolume(tank.getBottom());
        double etcMass = etc.calculateEtcMass(tank.getEtc(), tank.getShell());

        if(bottomVolume == 0 || roofMass == 0) {
            etcMass = 0.0;
        }

        double result = (shellVolume + bottomVolume) * tank.getDensity() +
                roofMass + etcMass;

        return new BigDecimal(result).setScale(1, RoundingMode.UP).doubleValue();
    }

    public int resultPrice(Tank tank, String tonPrice) {
        if (tonPrice.equals("")) {
            tonPrice = "0";
        }

        double price = resultMass(tank) * Integer.parseInt(tonPrice);

        return (int)price;
    }



    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    public Shell getShell() {
        return shell;
    }

    public void setShell(Shell shell) {
        this.shell = shell;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public Etc getEtc() {
        return etc;
    }

    public void setEtc(Etc etc) {
        this.etc = etc;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

}
