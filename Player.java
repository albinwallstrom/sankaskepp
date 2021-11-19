package BattleshipCode;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Player {

    public static void main(String[] args) {

        //Create an instance of the Boards class
        Boards board = new Boards();

        //Stores the random chosen board in the 2D-array
        /*int[][] selectedBoard = board.getRandomBoard();*/
        try {
            Socket socket = new Socket("localhost", 8888);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output,true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String text = "";





            while (!text.equals("qq")) {

                int [][] gameBoard = board.placeShips();


                String shot = board.randomShot();
                /*String shot = new Scanner(System.in).nextLine();*/

                writer.println(shot);

                String ignore = reader.readLine();
                System.out.println(ignore);

                String incomingMessage = reader.readLine();

                int [] guessCoordinates = board.getCoordinates(incomingMessage);

                text = board.sendText(guessCoordinates, gameBoard);

                writer.println(text);

                System.out.println(text);

                int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, gameBoard);

                gameBoard = board.updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);

                board.printGameBoard(gameBoard);

                /*Scanner scanner = new Scanner(System.in);*/
/*
                outMessage = scanner.nextLine();*/
            }
            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

