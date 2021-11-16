package BattleshipCode;

public class Coordinate  {

    // Constants for coordinates of rows and columns.
    public static int X = 10;
    public static  int Y = 10;

    // Create an array object "coordinate" of the class Location
    Location[][] coordinate = new Location[X][Y];




    //create a constructor to initialize a temporary location
    public Coordinate()
    {

        //nested loops to go through all rows and columns
        for (int x = 0; x < coordinate.length; X++)
        {
            for (int y = 0; y < coordinate[X].length; Y++)
            {
                Location tempLoc = new Location();
                coordinate[X][Y] = tempLoc;
            }
        }
    }

    // Mark a hit in this location by calling the markHit method  in the Location class.


    public void markHit(int X, int Y)
    {
        coordinate[X][Y].markHit();
    }

    // Mark a miss on this location.
    public void markMiss(int X, int Y)
    {
        coordinate[X][Y].markMiss();
    }

    // Set the status of this location object.
    public void setStatus(int X, int Y, int status)
    {
        coordinate[X][Y].setStatus(status);
    }

    // Get the status of this location in the grid
    public int getStatus(int X, int Y)
    {
        return coordinate[X][Y].getStatus();
    }



    // Set ship value
    public void setShip(int X, int Y, boolean value)
    {
        coordinate[X][Y].setShip(value);
    }

    // Return whether or not there is a ship here

    public boolean hasShip(int X, int Y)
    {
        return coordinate[X][Y].hasShip();
    }

    // Get the Location object at this x and y position
    public Location get(int X, int Y)
    {
        return coordinate[X][Y];
    }

}
