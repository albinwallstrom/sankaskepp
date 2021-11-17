package BattleshipCode;

public class Main {

    public static void main(String[] args) {

        //Work in progress
        int hit = 11;
        int miss = 12;
        //Create an instance of the Boards class
        Boards board = new Boards();
        int[][] gameBoard = board.placeShips();

        //Stores the random chosen board in the 2D-array
        int[][] selectedBoard = board.getRandomBoard();

        /*//Loops through the selected 2D-array(board) and prints it out in the Terminal
        for (int x = 0; x < selectedBoard.length; x++) {
            for (int y = 0; y < selectedBoard.length; y++) {
                System.out.print(selectedBoard[x][y] + " ");
            }
            System.out.println();
        }*/

        while (true) {

            int [] guessCoordinates = board.getCoordinates();
            /*int[] guessCoordinates = getCoordinates(gameBoardLength);*/

            int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, selectedBoard, hit, miss);

            /*int locationViewUpdate = evaluateCoordinates(guessCoordinates, selectedBoard, hit, miss);*/

            gameBoard = board.updateGameBoard(selectedBoard, guessCoordinates, locationViewUpdate);


            board.printGameBoard(gameBoard);


        }

    }
}

