package BattleshipCode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Create an instance of the Boards class
        Boards board = new Boards();
        board.placeShips();

        /*
        //Stores the random chosen board in the 2D-array
        var selectedBoard = board.getRandomBoard();

        //Loops through the selected 2D-array(board) and prints it out in the Terminal
        for (int x = 0; x < selectedBoard.length; x++) {
            for (int y = 0; y < selectedBoard.length; y++) {
                System.out.print(selectedBoard[x][y] + " ");
            }
            System.out.println();


        }
        */
    }
}