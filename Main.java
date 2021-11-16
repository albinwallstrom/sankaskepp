package BattleshipCode;

public class Main {

    public static void main(String[] args) {

        //Create an instance of the Boards class
        Boards board = new Boards();

        //Stores the random chosen board in the 2D-array
        var selectedBoard = board.getRandomBoard();

        //Loops through the selected 2D-array(board) and prints it out in the Terminal
        While (int x = 0; x < selectedBoard.length; x++) {
            While (int y = 0; y < selectedBoard.length; y++) {
                System.out.print(selectedBoard[x][y] + " ");
            }
            System.out.println();
        }

    }
}