package BattleshipCode;

import java.util.*;

public class Boards {

        //Constructor
        public Boards(){}

        //Creating the ships
        Ships s1 = new Ships("Aircraft carrier", 5);
        Ships s2 = new Ships("Battleship", 4);
        Ships s3 = new Ships("Battleship", 4);
        Ships s4 = new Ships("Cruiser", 3);
        Ships s5 = new Ships("Cruiser", 3);
        Ships s6 = new Ships("Cruiser", 3);
        Ships s7 = new Ships("Submarine", 2);
        Ships s8 = new Ships("Submarine", 2);
        Ships s9 = new Ships("Submarine", 2);
        Ships s10 = new Ships("Submarine", 2);

        //Creating an Arraylist in which ships can be stored
        public List<Ships> shipsList = new ArrayList<>();

        public List<Ships> getShipsList() {
                return shipsList;
        }

        //Variables
        private static final Random random = new Random();
        /*
        private static final int randomBoard = random.nextInt(5)+1;

        //Method for getting a random board
        public int[][] getRandomBoard(){
                var chosenBoard = new int[10][10];
                switch (randomBoard){
                        case 1:
                                chosenBoard = board1;
                                break;
                        case 2:
                                chosenBoard = board2;
                                break;
                        case 3:
                                chosenBoard = board3;
                                break;
                        case 4:
                                chosenBoard = board4;
                                break;
                        case 5:
                                chosenBoard = board5;
                                break;
                } return chosenBoard;

        }

        //2-D arrays with five different ship placements
        //Symbol meaning: 0=Water, 5=Aircraft Carrier, 4=Battleship, 3=Cruiser, 2=Submarine
        //Length*Number of each ship: H=5*1, B=4*2, C=3*3, S=2*4 (All ships are 1 in Width)

        private int[][] board1 =  {{0,0,0,0,0,0,0,0,0,4,},
                                   {0,5,5,5,5,5,0,0,0,4,},
                                   {0,0,0,0,0,0,0,0,0,4,},
                                   {0,2,0,0,0,3,3,3,0,4,},
                                   {0,2,0,2,0,0,0,0,0,0,},
                                   {0,0,0,2,0,0,2,2,0,0,},
                                   {0,2,0,0,0,0,0,0,0,4,},
                                   {0,2,0,0,0,3,3,3,0,4,},
                                   {0,0,0,0,0,0,0,0,0,4,},
                                   {3,3,3,0,0,0,0,0,0,4,}};

        private int[][] board2 =  {{0,0,0,5,0,0,0,0,4,0,},
                                   {0,3,0,5,0,0,0,0,4,0,},
                                   {0,3,0,5,0,2,2,0,4,0,},
                                   {0,3,0,5,0,0,0,0,4,0,},
                                   {0,0,0,5,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,3,3,3,},
                                   {0,4,0,2,2,0,0,0,0,0,},
                                   {0,4,0,0,0,0,0,2,0,3,},
                                   {0,4,0,0,2,2,0,2,0,3,},
                                   {0,4,0,0,0,0,0,0,0,3,}};

        private int[][] board3 =  {{0,3,3,3,0,0,4,4,4,4,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,4,4,4,4,0,0,0,0,5,},
                                   {0,0,0,0,0,0,0,0,0,5,},
                                   {0,2,2,0,2,0,0,0,0,5,},
                                   {0,0,0,0,2,0,0,0,0,5,},
                                   {0,0,3,0,0,0,2,2,0,5,},
                                   {0,0,3,0,0,0,0,0,0,0,},
                                   {0,0,3,0,3,3,3,0,2,0,},
                                   {0,0,0,0,0,0,0,0,2,0,}};

        private int[][] board4 =  {{0,0,0,0,0,0,0,0,0,0,},
                                   {0,3,3,3,0,0,0,3,3,3,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,2,2,0,5,0,2,2,0,0,},
                                   {0,0,0,0,5,0,0,0,0,0,},
                                   {3,3,3,0,5,0,0,0,4,0,},
                                   {0,0,0,0,5,0,2,0,4,0,},
                                   {0,2,2,0,5,0,2,0,4,0,},
                                   {0,0,0,0,0,0,0,0,4,0,},
                                   {0,0,0,4,4,4,4,0,0,0,}};

        private int[][] board5 =  {{0,0,0,0,0,0,0,0,4,0,},
                                   {0,0,0,0,0,0,0,0,4,0,},
                                   {3,3,3,0,0,0,2,0,4,0,},
                                   {0,0,0,0,5,0,2,0,4,0,},
                                   {0,0,3,0,5,0,0,0,0,0,},
                                   {4,0,3,0,5,0,0,0,0,0,},
                                   {4,0,3,0,5,0,2,2,0,0,},
                                   {4,0,0,0,5,0,0,0,0,2,},
                                   {4,0,0,0,0,0,2,0,0,2,},
                                   {0,0,3,3,3,0,2,0,0,0,}};
*/
        //2-D array, empty board
        private int[][] board6 =  {{0,0,0,0,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,0,0,0,},
                                   {0,0,0,0,0,0,0,0,0,0,}};

        //**WORK IN PROGRESS** Test of placing one ship(the first in the list)
        //                     at a random place, both horizontally and vertically
        public void placeShips(){
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
                while(!shipsList.isEmpty()){ //Always true for the moment, see line 169
                     int horizontalVertical = random.nextInt(2)+1;
                     int shipSize = getShipsList().get(0).getShipLength();
                     int xPlacement;
                     int yPlacement;
                     int[][] boardWithShips = board6;
                     if (horizontalVertical==1){
                             xPlacement = random.nextInt(boardWithShips.length);
                             yPlacement = random.nextInt(boardWithShips[0].length-shipSize+1);
                             for (int i = 0; i<shipSize; i++)
                                     boardWithShips[xPlacement][yPlacement+i]=shipSize;
                             for (int x = 0; x < boardWithShips.length; x++) {
                                     for (int y = 0; y < boardWithShips.length; y++) {
                                             System.out.print(boardWithShips[x][y] + " ");
                                     }
                                     System.out.println();
                             }
                     }else {
                             xPlacement = random.nextInt(boardWithShips.length-shipSize+1);
                             yPlacement = random.nextInt(boardWithShips[0].length);
                             for (int i = 0; i<shipSize; i++)
                                     boardWithShips[xPlacement+i][yPlacement]=shipSize;
                             for (int x = 0; x < boardWithShips.length; x++) {
                                     for (int y = 0; y < boardWithShips.length; y++) {
                                             System.out.print(boardWithShips[x][y] + " ");
                                     }
                                     System.out.println();
                             }
                     } break; //Temporarily break of the while-loop
                }
        }

}
