package com.wy;

public class mydoctor {

    public  String ID;
    public  String NAME;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public mydoctor() {
    }

    @Override
    public String toString() {
        return "mydoctor{" + "ID='" + ID + '\'' + ", NAME='" + NAME + '\'' + '}';
    }
}


