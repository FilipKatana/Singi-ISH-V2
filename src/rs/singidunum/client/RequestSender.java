package rs.singidunum.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestSender implements Runnable {

    public RequestSender() {}

    @Override
    public void run() {
        try {
            Socket sock = new Socket("localhost", 3000);
            PrintWriter writer = new PrintWriter(sock.getOutputStream());
            writer.println("TRANSFER|69|556|10000");
            writer.flush();
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
