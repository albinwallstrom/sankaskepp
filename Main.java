package BattleshipCode;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    //Variabler
    static int row;
    static int col;
    static int undetectedPartsOfShips = 30;
    static String alpha = "abcdefghij";

    public static void main(String[] args) {
        //Work in progress
        char hit = 'X';
        char miss = '-';
        int gameBoardLength = 10;


        //Create an instance of the Boards class
        Boards board = new Boards();

        //Stores the random chosen board in the 2D-array
        var selectedBoard = board.getRandomBoard();

        //Loops through the selected 2D-array(board) and prints it out in the Terminal
        for (int x = 0; x < selectedBoard.length; x++) {
            for (int y = 0; y < selectedBoard.length; y++) {
                System.out.print(selectedBoard[x][y] + " ");
            }
            System.out.println();
        }


        while (undetectedPartsOfShips > 0) {
            int [] guessCoordinates = getCoordinates(gameBoardLength);

            evaluateCoordinates(guessCoordinates, selectedBoard, hit, miss);
        }

    }
    //Get coordinates
    public static int[] getCoordinates(int gameBoardLength) {

        System.out.println("Tex:i shot 6c");

        String incomingShot = new Scanner(System.in).nextLine();
        char temp = incomingShot.charAt(8);
        int row = alpha.indexOf(temp);

        Pattern pattern = Pattern.compile("[^0-9]");
        String numbersOnly = pattern.matcher(incomingShot).replaceAll("");
        int col = Integer.parseInt(numbersOnly);

        return new int[]{row, col};
    }
    public static char evaluateCoordinates(int[] guessCoordinates, int[][] selectedBoard, char hit, char miss) {
        String text;
        int col = guessCoordinates[0];
        int row = guessCoordinates[1];
        char target = (char) selectedBoard[col][row];
        char backToChar = alpha.charAt(guessCoordinates[0]);

        if (target > 0) {
            text = "h shot " + guessCoordinates[1]+ backToChar;
            target = hit;
            //undetectedPartsOfShips--;
            //if ship = 0, text "game over"
        } else if (target == 0) {
            text = "m shot " + guessCoordinates[1]+backToChar;
            target=miss;
            // "s shot f5" -- sänkt + koordinaterna
        } else {
            text = "Du har redan skjutit där!"; // temporary
        }
        System.out.println(text);
        return target;
    }
}