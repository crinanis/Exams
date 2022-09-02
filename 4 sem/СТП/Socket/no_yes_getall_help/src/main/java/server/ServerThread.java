package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private BufferedReader in;
    private PrintStream out;

    private int qtyYes;
    private int qtyNo;

    public ServerThread(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintStream(socket.getOutputStream());
    }

    public void run() {
        String str;
        try {
            while ((str = in.readLine()) != null) {
                switch (str) {
                    case "/no":
                        qtyNo++;
                        break;
                    case "/yes":
                        qtyYes++;
                        break;
                    case "/help":
                        out.println("/no\n/yes\n/getall");
                        break;
                    case "/getall":
                        out.println("/no - " + qtyNo);
                        out.println("/yes - " + qtyYes);
                        break;
                }
            }
        } catch (Exception e) {

        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
