package com.sunderville.tanks.domain;

import java.util.ArrayList;
import java.util.List;

public class Shell {

    private String ring1;
    private String ring2;
    private String ring3;
    private String ring4;
    private String ring5;
    private String ring6;
    private String ring7;
    private String ring8;
    private String ring9;
    private String ring10;
    private String ring11;
    private String ring12;
    private String diameter;
    private final double RING_WIDTH = 1.5;

    public Shell(String diameter,
                 String ring1, String ring2, String ring3, String ring4, String ring5, String ring6,
                 String ring7, String ring8, String ring9, String ring10, String ring11, String ring12) {
        this.diameter = diameter;
        this.ring1 = ring1;
        this.ring2 = ring2;
        this.ring3 = ring3;
        this.ring4 = ring4;
        this.ring5 = ring5;
        this.ring6 = ring6;
        this.ring7 = ring7;
        this.ring8 = ring8;
        this.ring9 = ring9;
        this.ring10 = ring10;
        this.ring11 = ring11;
        this.ring12 = ring12;
    }

    public double calculateShellVolume(Shell shell) {
        double perimeter = (2.0 * Math.PI) * (Double.parseDouble(shell.getDiameter())/2.0/1000.0);
        List<String> allRingsTextList = new ArrayList<>();
        allRingsTextList.add(shell.getRing1());
        allRingsTextList.add(shell.getRing2());
        allRingsTextList.add(shell.getRing3());
        allRingsTextList.add(shell.getRing4());
        allRingsTextList.add(shell.getRing5());
        allRingsTextList.add(shell.getRing6());
        allRingsTextList.add(shell.getRing7());
        allRingsTextList.add(shell.getRing8());
        allRingsTextList.add(shell.getRing9());
        allRingsTextList.add(shell.getRing10());
        allRingsTextList.add(shell.getRing11());
        allRingsTextList.add(shell.getRing12());

        double allRingsVolume = 0;
        for (String s : allRingsTextList) {
            if (s.equals("")) s = "0";
            double sD = RING_WIDTH * perimeter * (Double.parseDouble(s)/1000.0);
            allRingsVolume = allRingsVolume + sD;
        }
        return allRingsVolume;
    }


    public String getRing1() {
        return ring1;
    }

    public void setRing1(String ring1) {
        this.ring1 = ring1;
    }

    public String getRing2() {
        return ring2;
    }

    public void setRing2(String ring2) {
        this.ring2 = ring2;
    }

    public String getRing3() {
        return ring3;
    }

    public void setRing3(String ring3) {
        this.ring3 = ring3;
    }

    public String getRing4() {
        return ring4;
    }

    public void setRing4(String ring4) {
        this.ring4 = ring4;
    }

    public String getRing5() {
        return ring5;
    }

    public void setRing5(String ring5) {
        this.ring5 = ring5;
    }

    public String getRing6() {
        return ring6;
    }

    public void setRing6(String ring6) {
        this.ring6 = ring6;
    }

    public String getRing7() {
        return ring7;
    }

    public void setRing7(String ring7) {
        this.ring7 = ring7;
    }

    public String getRing8() {
        return ring8;
    }

    public void setRing8(String ring8) {
        this.ring8 = ring8;
    }

    public String getRing9() {
        return ring9;
    }

    public void setRing9(String ring9) {
        this.ring9 = ring9;
    }

    public String getRing10() {
        return ring10;
    }

    public void setRing10(String ring10) {
        this.ring10 = ring10;
    }

    public String getRing11() {
        return ring11;
    }

    public void setRing11(String ring11) {
        this.ring11 = ring11;
    }

    public String getRing12() {
        return ring12;
    }

    public void setRing12(String ring12) {
        this.ring12 = ring12;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public double getRING_WIDTH() {
        return RING_WIDTH;
    }
}
