package BattleshipCode;

public class Ships {
    private String type;
    private int length;
    private int shipNumber;
    private int shipHealth;

    public Ships(String type, int length, int shipNumber, int shipHealth) {
        this.type = type;
        this.length = length;
        this.shipNumber = shipNumber;
        this.shipHealth = shipHealth;
    }

    public int getShipNumber() {
        return shipNumber;
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

