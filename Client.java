package BattleshipCode;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 555);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            System.out.println("Uppkopplad till server");
            System.out.println("Genererar din spelplan..");
            String text = "";

            while(!text.equals("qq")){
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
                System.out.println("Skjut ditt skott");
                Scanner scanner = new Scanner(System.in);
                text = scanner.nextLine();
                writer.println(text);
                System.out.println("Servern skjuter..");
                String inMessage = reader.readLine();
                System.out.println("Server sköt på kordinat: " +inMessage);
            }
            socket.close();
            System.out.println("DEN STÄNGS AV");
        }catch (Exception e ){
            System.out.println(e);
        }
    }
}
