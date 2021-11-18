package BattleshipCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Create an instance of the Boards class
        Boards board = new Boards();

        int [][] gameBoard = board.placeShips();

        //Stores the random chosen board in the 2D-array
        int[][] selectedBoard = board.getRandomBoard();

        try (ServerSocket serverSocket = new ServerSocket(8888)){
            Socket socket = serverSocket.accept();
            System.out.println("Spelare 1 har anslutit");
            System.out.println("Spelare 1 gör sig redo att förlora....");
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);

            String text = "";

            while (true) {



                String incomingMessage = reader.readLine();

                int [] guessCoordinates = board.getCoordinates(incomingMessage);

                text = board.sendText(guessCoordinates, selectedBoard);

                writer.println(text);

                System.out.println(text);

                int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, selectedBoard);

                gameBoard = board.updateGameBoard(selectedBoard, guessCoordinates, locationViewUpdate);

                board.printGameBoard(gameBoard);

                Scanner scanner = new Scanner(System.in);

                String outMessage = scanner.nextLine();

                writer.println(outMessage);

                String ignore = reader.readLine();
                System.out.println(ignore);

                /*System.out.println("Väntar på svar...");*/
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

