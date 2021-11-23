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

}
                public class arr1 {

                        public static void main(String[] args) {
                                //fields
                                char[][] board = new char[5][5]; // Spelbrädet.
                                ArrayList<arr1> arr = new arr1<>(); // array list för att hålla koll på objekten
                                initialBoard(board);
                                Random computer = new Random(); //skapar ett random numner för datorn.
                                int row, col;
                                Scanner user = new Scanner(System.in);


                                for (int i = 0; i <= 4; i++) {
                                        row = computer.nextInt(5);
                                        col = computer.nextInt(5);
                                        arr1 battleship = new arr1(row, col);
                                }
                                System.out.println(arr1);
                                int turnsLeft = 8;
                                int numShips = 4;
                                do {
                                        System.out.println("You have " + turnsLeft + " turns left." + "\n"
                                                + "There are " + numShips + " ships left.");
                                        System.out.println("Please make a guess (row, column)");

                                        row = user.nextInt();
                                        col = user.nextInt();
                                        arr1 userGuess = new arr1(row, col);

                                        if (row > 4 || col > 4) {
                                                System.out.println("Your move is invalid.");
                                        } else if (board[row][col] == 'X' || board[row][col] == '*') {
                                                System.out.println("You have already guessed that location");
                                        }
                                        for (arr1 loc : arr1) {
                                                if (arr1.contains(userGuess)) {
                                                        arr1.remove(userGuess);
                                                        board[row][col] = '*';
                                                        updateBoard(board);
                                                        System.out.println("You hit a ship");
                                                        break;
                                                } else {
                                                        board[row][col] = 'X';
                                                        updateBoard(board);
                                                        break;
                                                }
                                        }
                                } while (turnsLeft != 0);
                        }

                        private static void remove(arr1 userGuess) {
                        }

                        private static boolean contains(arr1 userGuess) {
                        }

                        //printBoard method
                        public static void initialBoard(char[][] board) {
                                //for loops iterate through each 
                                for (int row = 0; row < board.length; row++) {
                                        for (int col = 0; col < board[row].length; col++) {
                                                board[row][col] = 'O';
                                                System.out.print(board[row][col] + " ");
                                        }
                                        System.out.println();
                                }
                        }

                        public static void updateBoard(char[][] board) {
                                for (int row = 0; row < board.length; row++) {
                                        for (int col = 0; col < board[row].length; col++) {
                                                System.out.print(board[row][col] + " ");
                                        }
                                }
                        }

                        private static class ArrayList<T> {
                        }
                }