package BattleshipCode;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Player {

    public static void main(String[] args) {

        //Create an instance of the Boards class
        Boards board = new Boards();

        try {
            Socket socket = new Socket("localhost", 8889);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output,true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            System.out.println("Uppkopplad och redo");

            String text = "";

            int [][] gameBoard = board.placeShips();

            board.printGameBoard(gameBoard);

            while (!text.equals("qq")) {

                String shot = board.randomShot();

                writer.println(shot);

                String ignore = reader.readLine();
                System.out.println(ignore);

                String incomingMessage = reader.readLine();

                int [] guessCoordinates = board.getCoordinates(incomingMessage);

                int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, gameBoard);

                text = board.returnText(guessCoordinates, gameBoard);

                writer.println(text);

                System.out.println(text);



                gameBoard = board.updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);

                board.printGameBoard(gameBoard);

            }
            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

