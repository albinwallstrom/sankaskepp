package BattleshipCode;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            //Create an instance of the Boards class
                        Boards board = new Boards();

                        int [][] gameBoard = board.placeShips();

                        //Stores the random chosen board in the 2D-array
                        int[][] selectedBoard = board.getRandomBoard();
            String text = "";

            String outMessage = "";

            while (!text.equals("exit")) {
                Scanner scanner = new Scanner(System.in);
                text = scanner.nextLine();
                writer.println(text);

                String inMessage = reader.readLine();
                System.out.println(inMessage);
                while (true) {
                    inMessage = reader.readLine();
                    System.out.println("Servern säger: " + inMessage);
                    //scanner = new Scanner(System.in);
                    //outMessage = scanner.nextLine();
                    //writer.println(outMessage);

                    int [] guessCoordinates = board.getCoordinates(inMessage);


                    int locationViewUpdate = board.evaluateCoordinates(guessCoordinates, selectedBoard);

                    gameBoard = board.updateGameBoard(selectedBoard, guessCoordinates, locationViewUpdate);


                    board.printGameBoard(gameBoard);
                    System.out.println("Väntar på svar");
                }
            }
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
