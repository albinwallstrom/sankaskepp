package BattleshipCode;

import java.util.Random;
import java.util.Scanner;

public class Boards {

        //Constructor
        public Boards(){}

        //Variables
        private static final Random random = new Random();
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

        public static void Battle(){
                playerTurn();
                Scanner scan = new Scanner(System.in);
                System.out.println("Din tur");
                String Shot = scan.nextLine();  // Read user input
                System.out.println("Du sköt " + scan);
}

        private static void playerTurn() {
                System.out.println("Shot on target");
                int x = -1, y = -1;
                do {
                        Scanner input = new Scanner(System.in);
                        System.out.print("Enter X coordinate: ");
                        x = input.nextInt();
                        System.out.print("Enter Y coordinate: ");
                        y = input.nextInt();

                        int numRows;
                        int numCols;
                        if ((
                                x >= 0 && x < numRows) && (y >= 0 && y < numCols))
        }
        }
