package BattleshipCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

<<<<<<< Updated upstream
        try(ServerSocket serverSocket = new ServerSocket(555)){
            Socket socket = serverSocket.accept();
            System.out.println("Uppkopplad till klient");
            System.out.println("Genererar din spelplan..");
=======
    //Create an instance of the Boards class
            Boards board = new Boards();

            int [][] gameBoard = board.placeShips();

            //Stores the random chosen board in the 2D-array
            int[][] selectedBoard = board.getRandomBoard();


        // write your code here
        try(ServerSocket serverSocket = new ServerSocket(8888)){
            Socket socket = serverSocket.accept();
            //System.out.println("Uppkopplad till klient");
            //System.out.println("Klienten skriver...");
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);
>>>>>>> Stashed changes

            String inMessage = "";
            String outMessage = "";

            while (true) {
<<<<<<< Updated upstream
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
                System.out.println("Klienten skjuter...");
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                PrintWriter writer = new PrintWriter(output, true);
                inMessage = reader.readLine();
                System.out.println("Klienten sköt på kordinat: " + inMessage);
                System.out.println("Skjut ditt skott");
                Scanner scanner = new Scanner(System.in);
                outMessage = scanner.nextLine();
                writer.println(outMessage);
            }
        }
=======
                int [] guessCoordinates = board.getCoordinates(inMessage);
                int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, selectedBoard);
                gameBoard = board.updateGameBoard(selectedBoard, guessCoordinates, locationViewUpdate);
                inMessage = reader.readLine();
                System.out.println(inMessage);
                Scanner scanner = new Scanner(System.in);
                outMessage = scanner.nextLine();
                writer.println(outMessage);
                System.out.println("Väntar på svar");
                //int [] guessCoordinates = board.getCoordinates(inMessage);


                //int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, selectedBoard);

                //gameBoard = board.updateGameBoard(selectedBoard, guessCoordinates, locationViewUpdate);


                board.printGameBoard(gameBoard);
            }
        }


        catch (IOException e) {
            e.printStackTrace();
        }


        /*//Create an instance of the Boards class
        Boards board = new Boards();

        int [][] gameBoard = board.placeShips();

        //Stores the random chosen board in the 2D-array
        int[][] selectedBoard = board.getRandomBoard();



        while (true) {

            int [] guessCoordinates = board.getCoordinates();


            int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, selectedBoard);

            gameBoard = board.updateGameBoard(selectedBoard, guessCoordinates, locationViewUpdate);


            board.printGameBoard(gameBoard);


        }*/

>>>>>>> Stashed changes

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}