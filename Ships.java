package BattleshipCode;

import java.awt.*;
import java.util.ArrayList;

public class Ships {
    private String type;
    private int length;
    //Test
    private int shipNumber;
    //New variable
    private int shipHealth = length;

    //Empty Constructor
    public Ships() {
    }

    public Ships(String type, int length) {
        this.type = type;
        this.length = length;
    }

    public Ships(String type, int length, int shipNumber) {
        this.type = type;
        this.length = length;
        this.shipNumber = shipNumber;
    }

    public Ships(String type, int length, int shipNumber, int shipHealth) {
        this.type = type;
        this.length = length;
        this.shipNumber = shipNumber;
        this.shipHealth = shipHealth;
    }

    public int getShipNumber() {
        return shipNumber;
    }

    public int getShipHealth() {
        return shipHealth;
    }

    //Currently not in use
    public String getType() {
        return type;
    }

    //Currently not in use
    public void setType(String type) {
        this.type = type;
    }

    public int getShipLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Ship" +
                "(Type = " + type +
                ", Length = " + length +
                ')';
    }

    //hit
    public void hit() {
        shipHealth--;
    }

    //Destroyed
    public boolean isDestroyed() {
        if (shipHealth == 0) {
            return true; }
        else
            return false;

    }
}

