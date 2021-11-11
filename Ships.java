package BattleshipCode;

public class Ships {
    private String type;
    private int length;



    public Ships(String type, int length){
        this.type = type;
        this.length = length;
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
}
