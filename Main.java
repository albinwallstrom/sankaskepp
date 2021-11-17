package BattleshipCode;

public class Main {

    public static void main(String[] args) {

        //Create an instance of the Boards class
        Boards board = new Boards();

        int [][] gameBoard = board.placeShips();

        //Stores the random chosen board in the 2D-array
        int[][] selectedBoard = board.getRandomBoard();



        while (true) {

            int [] guessCoordinates = board.getCoordinates();


            int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, selectedBoard);

            gameBoard = board.updateGameBoard(selectedBoard, guessCoordinates, locationViewUpdate);


            board.printGameBoard(gameBoard);


        }

    }
}

