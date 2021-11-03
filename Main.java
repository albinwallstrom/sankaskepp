package BattleshipCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(555)){
            Socket socket = serverSocket.accept();
            System.out.println("Uppkopplad till klient");
            System.out.println("Genererar din spelplan");

            String inMessage = "";
            String outMessage = "";

            while (true) {
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
                Scanner scanner = new Scanner(System.in);
                outMessage = scanner.nextLine();
                writer.println(outMessage);
                System.out.println("Väntar på svar");
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}