package BattleshipCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Create an instance of the Boards class
        Boards board = new Boards();

        int [][] gameBoard;

        //Stores the random chosen board in the 2D-array
        /*int[][] selectedBoard = board.getRandomBoard();*/

        try (ServerSocket serverSocket = new ServerSocket(8889)){
            Socket socket = serverSocket.accept();
            System.out.println("Spelare 1 har anslutit");
            System.out.println("Spelare 1 gör sig redo att förlora....");
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);

            String text = "";

            gameBoard = board.placeShips();


            board.printGameBoard(gameBoard);

            while (true) {


                String incomingMessage = reader.readLine();

                int [] guessCoordinates = board.getCoordinates(incomingMessage);


                int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, gameBoard);


                text = board.returnText(guessCoordinates, gameBoard);

                writer.println(text);

                System.out.println(text);

                gameBoard = board.updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);

                board.printGameBoard(gameBoard);

                String shot = board.randomShot();
                writer.println(shot);

                String ignore = reader.readLine();
                System.out.println(ignore);

            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

