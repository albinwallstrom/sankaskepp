package BattleshipCode;

import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class Boards {
        //Variables
        private int[][] gameBoard;
        final private String alpha = "abcdefghij";
        private int totalShips = 10;
        private int water = 0;
        private int gameBoardLength = 10;
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

        private static final int randomBoard = random.nextInt(1) + 1;

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
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};

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
                while (!shipsList.isEmpty()) { //Always true for the moment, see line 169
                        int horizontalVertical = random.nextInt(2) + 1;
                        int shipSize = getShipsList().get(0).getShipLength();
                        int shipNumber = getShipsList().get(0).getShipNumber();
                        int xPlacement;
                        int yPlacement;
                        int[][] boardWithShips = board6;
                        if (horizontalVertical == 1) {
                                xPlacement = random.nextInt(boardWithShips.length);
                                yPlacement = random.nextInt(boardWithShips[0].length - shipSize + 1);

                                for (int i = 0; i < shipSize; i++)
                                        boardWithShips[xPlacement][yPlacement + i] = shipNumber;
                                for (int x = 0; x < boardWithShips.length; x++) {
                                        for (int y = 0; y < boardWithShips.length; y++) {
                                                System.out.print(boardWithShips[x][y] + " ");
                                        }
                                        System.out.println();
                                }
                        } else {
                                xPlacement = random.nextInt(boardWithShips.length - shipSize + 1);
                                yPlacement = random.nextInt(boardWithShips[0].length);

                                for (int i = 0; i < shipSize; i++)
                                        boardWithShips[xPlacement + i][yPlacement] = shipNumber;/*shipSize;*/
                                for (int x = 0; x < boardWithShips.length; x++) {
                                        for (int y = 0; y < boardWithShips.length; y++) {
                                                System.out.print(boardWithShips[x][y] + " ");
                                        }
                                        System.out.println();
                                }
                        }
                        break; //Temporarily break of the while-loop
                }
                return gameBoard;

        }

        public void printGameBoard(int[][] gameBoard) {

                //Loops through the selected 2D-array(board) and prints it out in the Terminal
                for (int x = 0; x < getRandomBoard().length; x++) {
                        for (int y = 0; y < getRandomBoard().length; y++) {
                                System.out.print(board6[x][y] + "\t");
                        }
                        System.out.println();
                }
        }



        //Get coordinates method
        public int[] getCoordinates() {
                //Takes the incoming string, takes the last letter and transforms it into a number.
                String incomingShot = new Scanner(System.in).nextLine();
                char temp = incomingShot.charAt(8);
                int x = alpha.indexOf(temp);

                //Removes everything but the number from the incoming string and the parse it into an Integer
                Pattern pattern = Pattern.compile("[^0-9]");
                String numbersOnly = pattern.matcher(incomingShot).replaceAll("");
                int y = Integer.parseInt(numbersOnly);

                //Returns the coordinates
                return new int[]{x, y};
        }

        //Evaluates the coordinates if it is a hit, a miss, if a ship has been destroyed or if it is game over.
        public int evaluateCoordinates(int[] guessCoordinates,int[][] selectedGameBoard) {
                String text = "";
                //locate the target of the shot in the 2d-Array
                int y = guessCoordinates[0];
                int x = guessCoordinates[1];
                int target = selectedGameBoard[y][x];
                //Change the int back to a char.
                char backToChar = alpha.charAt(y);
                //Check if it is a miss, and returns a string if so
                if (target == 0 || target > 10) {
                        text = "m shot " + x + backToChar;
                        target = miss;
                        //Check if it is a hit and locate in the shipsList  which ship that has been hit, and mark the ship as hit.
                } else if (target > 0 || target < 11) {
                        int i = target - 1;
                        getShipsList().get(i).hit();
                        target = hit;
                        //Is the ship destroyed? removes one ship from the total of ships and returns the string for the opponent to read.
                        // Is all the ships destroyed? returns the message game over
                        //If none of the above is correct, then it's just a hit
                        //The "target" changes number so the ship cant be hit again.
                        if (getShipsList().get(i).isDestroyed()) {
                                text = "s shot " + x + backToChar;
                                totalShips--;
                                if (totalShips == 0)
                                        text = "game over";
                        } else
                                text = "h shot " + x + backToChar;
                }

                System.out.println(text);
                return target;
        }

        //Updates the game board with the previous guess
        public int[][] updateGameBoard(int[][] gameBoard, int[] guessCoordinates, int locationViewUpdate) {
                int x = guessCoordinates[0];
                int y = guessCoordinates[1];
                gameBoard[x][y] = locationViewUpdate;
                return gameBoard;

        }
}
