package BattleshipCode;

import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class Boards {
        //Variables
        final private String alpha = "abcdefghij";
        private int totalShips = 10;
        private final int water = 0;
        private int gameBoardLength = 10;
        private int[][] gameBoard = new int[gameBoardLength][gameBoardLength];
        private int hit = 11;
        private int miss = 12;

        //Constructor
        public Boards() {
        }

        //Creating the ships

        Ships s1 = new Ships("Aircraft carrier", 5, 1, 5);
        Ships s2 = new Ships("Battleship", 4, 2, 4);
        Ships s3 = new Ships("Battleship", 4, 3, 4);
        Ships s4 = new Ships("Cruiser", 3, 4, 3);
        Ships s5 = new Ships("Cruiser", 3, 5, 3);
        Ships s6 = new Ships("Cruiser", 3, 6, 3);
        Ships s7 = new Ships("Submarine", 2, 7, 2);
        Ships s8 = new Ships("Submarine", 2, 8, 2);
        Ships s9 = new Ships("Submarine", 2, 9, 2);
        Ships s10 = new Ships("Submarine", 2, 10, 2);

        //Creating an Arraylist in which ships can be stored
        public List<Ships> shipsList = new ArrayList<>();

        public List<Ships> getShipsList() {
                return shipsList;
        }

        //Variables
        private static final Random random = new Random();

        /*private static final int randomBoard = random.nextInt(1) + 1;

        //Method for getting a random board
        public int[][] getRandomBoard() {
                var chosenBoard = new int[10][10];
                switch (randomBoard) {
                        case 1:
                                chosenBoard = board6;
                                break;
                }
                return chosenBoard;

        }
        //2-D array, empty board
        private int[][] board6 = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};*/

        //**WORK IN PROGRESS** Test of placing one ship(the first in the list)
        //                     at a random place, both horizontally and vertically
        public int[][] placeShips() {

                shipsList.add(s1);
                shipsList.add(s2);
                shipsList.add(s3);
                shipsList.add(s4);
                shipsList.add(s5);
                shipsList.add(s6);
                shipsList.add(s7);
                shipsList.add(s8);
                shipsList.add(s9);
                shipsList.add(s10);

                int[][] gameBoard = new int[gameBoardLength][gameBoardLength];
                for (int i = 0; i < shipsList.size(); i++) {
                        int shipSize = getShipsList().get(i).getShipLength();
                        int shiNumber = getShipsList().get(i).getShipNumber();
                        //System.out.println("Placing ship with length: " + i);
                        // start point of the ship and direction
                        int x = random.nextInt(gameBoardLength);
                        int y = random.nextInt(gameBoardLength);
                        boolean vertical = random.nextBoolean();

                        // correct start point so that the ship could fit in the field
                        if (vertical) {
                                if (y + shipSize > gameBoardLength) {
                                        y -= shipSize;
                                }
                        } else if (x + shipSize >gameBoardLength) {
                                x -= shipSize;
                        }
                        //System.out.println("Start point: " + x + ", " + y + "; dir: " + (vertical ? "VERTICAL" : "HORIZONTAL"));
                        boolean possiblePlacement = true;
                        // check for free space
                        if (vertical) {
                                for (int m = y; m < y + shipSize; m++) {
                                        if (gameBoard[m][x] != 0) {
                                                //System.out.println("Neighbors found, " + x + ", " + m);
                                                possiblePlacement = false;
                                                break;
                                        }
                                }
                        } else {
                                for (int n = x; n < x + shipSize; n++) {
                                        if (gameBoard[y][n] != 0) {
                                                //System.out.println("Neighbors found, " + n + ", " + y);
                                                possiblePlacement = false;
                                                break;
                                        }
                                }
                        }
                        if (!possiblePlacement) {  // no free space found, retry
                                i--;
                                continue;
                        }

                        // fill in the adjacent cells
                        if (vertical) {
                                for (int m = Math.max(0, x - 1); m < Math.min(gameBoardLength, x + 2); m++) {
                                        for (int n = Math.max(0, y - 1); n < Math.min(gameBoardLength, y + shipSize + 1); n++) {
                                                gameBoard[n][m] = 13;
                                        }
                                }
                        } else {
                                for (int m = Math.max(0, y - 1); m < Math.min(gameBoardLength, y + 2); m++) {
                                        for (int n = Math.max(0, x - 1); n < Math.min(gameBoardLength, x + shipSize + 1); n++) {
                                                gameBoard[m][n] = 13;
                                        }
                                }
                        }
                        // fill in the ship cells
                        for (int j = 0; j < shipSize; j++) {
                                gameBoard[y][x] = shiNumber;
                                if (vertical) {
                                        y++;
                                } else {
                                        x++;
                                }
                        }
                }
                return gameBoard;
        }

        public void printGameBoard(int[][] gameBoard) {

                //Loops through the selected 2D-array(board) and prints it out in the Terminal
                for (int x = 0; x < gameBoardLength; x++) {
                        for (int y = 0; y < gameBoardLength; y++) {
                                System.out.print(gameBoard[x][y] + "\t");
                        }
                        System.out.println();
                }
        }



        //Get coordinates method
        public int[] getCoordinates(String incomingMessage) {
                //Takes the incoming string, takes the last letter and transforms it into a number.
                /*String incomingShot = new Scanner(System.in).nextLine();*/
                char temp = incomingMessage.charAt(8);
                int x = alpha.indexOf(temp);

                //Removes everything but the number from the incoming string and the parse it into an Integer
                Pattern pattern = Pattern.compile("[^0-9]");
                String numbersOnly = pattern.matcher(incomingMessage).replaceAll("");
                int y = Integer.parseInt(numbersOnly);

                //Returns the coordinates
                return new int[]{x, y};
        }

        //Evaluates the coordinates if it is a hit, a miss, if a ship has been destroyed or if it is game over.
        public int evaluateCoordinates(int[] guessCoordinates, int [][] gameBoard) {
                //locate the target of the shot in the 2d-Array
                int y = guessCoordinates[0];
                int x = guessCoordinates[1];
                int target = gameBoard[y][x];
                //Check if it is a miss and marks it on the board
                if (target == 0 || target > 10) {
                        target = miss;
                        //Check if it is a hit and locate in the shipsList  which ship that has been hit, and mark the ship as hit.
                } else if (target > 0 || target < 11) {
                        int i = target - 1;
                        getShipsList().get(i).hit();
                        target = hit;
                        //Is the ship destroyed? Removes one ship from the total of ships.
                        //The "target" changes number so the ship can't be hit again.
                        if (getShipsList().get(i).isDestroyed())
                                totalShips--;
                }
                return target;
        }


        public String sendText (int[] guessCoordinates, int [][] gameBoard) {
                String text = "";
                //locate the target of the shot in the 2d-Array
                int y = guessCoordinates[0];
                int x = guessCoordinates[1];
                int target = gameBoard[y][x];
                //Change the int back to a char.
                char backToChar = alpha.charAt(y);
                //Check if it is a miss, and returns a string if so
                if (target == 0 || target > 10) {
                        text = "m shot " + x + backToChar;
                        //Check if it is a hit and locates which ship that has been hit in the shipsList.
                } else if (target > 0 || target < 11) {
                        int i = target - 1;
                        //Is the ship destroyed? returns "s shot " + coordinates
                        // Is all the ships destroyed? returns the message game over
                        //If none of the above is correct, then it's just a hit
                        if (getShipsList().get(i).isDestroyed()) {
                                text = "s shot " + x + backToChar;
                                if (totalShips == 0)
                                        text = "game over";
                        } else
                                text = "h shot " + x + backToChar;
                }
                return text;
        }

        //Updates the game board with the previous guess
        public int[][] updateGameBoard(int[][] gameBoard, int[] guessCoordinates, int locationViewUpdate) {
                int x = guessCoordinates[0];
                int y = guessCoordinates[1];
                gameBoard[x][y] = locationViewUpdate;
                return gameBoard;

        }
        public String randomShot() throws InterruptedException {
                Thread.sleep(2000);


                int x = random.nextInt(10);
                int y = random.nextInt(10);

                char letter = alpha.charAt(y);

                System.out.println("i shot " + x+letter);

                return "i shot " +x+letter;
        }

}
