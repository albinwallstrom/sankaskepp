package BattleshipCode;

import java.util.Scanner;

//Är ej klar men såhär ser det ut hitintills. Lagt till så att man ser om det är en träff eller inte,
// och en enklare skanner för att se så det funkar.

public class Main {
    //Variabler
    static int row;
    static int col;
    static int undetectedPartsOfShips = 30;

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
            int [] guessCoordinates = getUserCoordinates(gameBoardLength);

            evaluateUserCoordinates(guessCoordinates, selectedBoard, hit, miss);
        }

    }
    //få koordinaterna från användaren. Talet kan inte vara mindre än 0 eller större än 9
    public static int[] getUserCoordinates(int gameBoardLength) {
        do {
            System.out.print("Rad: ");
            row = new Scanner(System.in).nextInt();
        } while (row < 0 || row > gameBoardLength);
        do {
            System.out.print("Kolumn: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 0 || col > gameBoardLength);
        return new int[]{row, col};
    }
    public static char evaluateUserCoordinates(int[] guessCoordinates, int[][] selectedBoard, char hit, char miss) {
        String text;
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        char target = (char) selectedBoard[row][col];
        if (target > 0) {
            text = "Träff!";
            target = hit;
            undetectedPartsOfShips--;
        } else if (target == 0) {
            text = "Miss!";
            target=miss;
        } else {
            text = "Du har redan skjutit där!";
        }
        System.out.println(text);
        return target; //används ej än
    }
}