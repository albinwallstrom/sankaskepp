package BattleshipCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        //Create an instance of the Boards class
        Boards board = new Boards();

        try (ServerSocket serverSocket = new ServerSocket(8889)){
            Socket socket = serverSocket.accept();
            System.out.println("Ansluter till motståndare..");
            System.out.println("Uppkopplad till spelare 1....");
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);
            String text = "";
            int[][]gameBoard = board.placeShips();

            while (true) {

                String incomingMessage = reader.readLine();
                int [] guessCoordinates = board.getCoordinates(incomingMessage);
                int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, gameBoard);
                text = board.returnText(guessCoordinates, gameBoard);
                writer.println(text);
                gameBoard = board.updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);
                board.printGameBoard(gameBoard);
                String shot = board.randomShot();
                writer.println(shot);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

