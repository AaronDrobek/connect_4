package com.drobek.practice;


public class Target {

    private String displayIcon;
    private boolean isOccupied ;

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon){
        this.displayIcon = displayIcon;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied= occupied;
    }
}

