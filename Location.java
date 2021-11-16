package BattleshipCode;

class Location {

    // Status of the ship
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;

    // Variables
    private int status; // statusn of the location
    private boolean hasShip; // if the location has a ship or not


    // Location constructor
    public Location() {
        // Set initial values
        status = 0;
        hasShip = false;

    }

    // Was this Location hit?
    public boolean checkHit() {
        if (status == HIT)
            return true;
        else
            return false;
    }

    // Was this location missed?
    public boolean checkMiss() {
        if (status == MISSED)
            return true;
        else
            return false;
    }

    // Was this location unguessed?
    public boolean isUnguessed() {
        if (status == UNGUESSED)
            return true;
        else
            return false;
    }

    // Mark this location a hit.
    public void markHit() {
        setStatus(HIT);
    }

    // Mark this location a miss.
    public void markMiss() {
        setStatus(MISSED);
    }

    // Return whether or not this location has a ship.
    public boolean hasShip() {
        return hasShip;
    }

    //Setters and getters

    // Set the value of whether this location has a ship.
    public void setShip(boolean value) {
        this.hasShip = value;
    }

    // Set the status of this Location.
    public void setStatus(int status)
    {
        this.status = status;
    }

    // Get the status of this Location.
    public int getStatus()
    {
        return status;
    }


}
