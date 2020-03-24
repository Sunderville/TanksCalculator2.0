package com.sunderville.tanks.domain;

public class Bottom {

    private String bottomRimThikness;
    private String bottomCenterThikness;
    private String diameter;
    private static final double RIM_WIDTH = 1.33;

    public Bottom(String diameter, String bottomRimThikness, String bottomCenterThikness) {
        this.diameter = diameter;
        this.bottomRimThikness = bottomRimThikness;
        this.bottomCenterThikness = bottomCenterThikness;
    }

    public double calculateBottomVolume(Bottom bottom) {
        return calculateCenterVolume(bottom.getDiameter(), bottom.getBottomCenterThikness()) +
                calculateRimVolume(bottom.getDiameter(), bottom.getBottomRimThikness());
    }

    private double calculateCenterVolume(String diameter, String center) {

        if(center.equals("")) center = "0";

        double diameter1 = Double.parseDouble(diameter)/1000.0;
        double diameter2center = diameter1 - RIM_WIDTH *2.0;

        double radiusCenter = diameter2center/2.0;

        double centerSquare = 3.14 * (radiusCenter * radiusCenter);

        return centerSquare * Double.parseDouble(center)/1000.0;
    }

    private double calculateRimVolume(String diameter, String rim) {

        if(rim.equals("")) rim = "0";

        double diameter1 = Double.parseDouble(diameter)/1000.0;
        double diameter2center = diameter1 - RIM_WIDTH *2.0;

        double radiusBig = diameter1/2.0;
        double radiusCenter = diameter2center/2.0;

        double wholeSquare = 3.14 * (radiusBig * radiusBig);
        double centerSquare = 3.14 * (radiusCenter * radiusCenter);
        double rimSquare = wholeSquare - centerSquare;

        return (rimSquare * Double.parseDouble(rim)/1000.0);
    }

    public String getBottomRimThikness() {
        return bottomRimThikness;
    }

    public void setBottomRimThikness(String bottomRimThikness) {
        this.bottomRimThikness = bottomRimThikness;
    }

    public String getBottomCenterThikness() {
        return bottomCenterThikness;
    }

    public void setBottomCenterThikness(String bottomCenterThikness) {
        this.bottomCenterThikness = bottomCenterThikness;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }
}
