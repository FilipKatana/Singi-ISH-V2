package rs.singidunum.server;

import rs.singidunum.banka.zapisi.Racun;
import rs.singidunum.banka.zapisi.Transakcija;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class RequestHandler implements Runnable {
    private Socket socket;
    private HashMap<String, Racun> accounts;

    public RequestHandler(Socket s, HashMap<String, Racun> accounts) {
        socket = s;
        this.accounts = accounts;
    }

    @Override
    public void run() {
        try {
            BufferedReader socketStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String rawRequest = socketStream.readLine();
            String[] request = rawRequest.split("\\|");
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            switch (request[0]) {
                case "STATE":
                    System.out.println("Stanje na računu " + accounts.get(request[1]).getSuma());

                case "TRANSFER":
                    new Transakcija(accounts.get(request[2]),
                            accounts.get(request[1]), Long.parseLong(request[3]));
                    System.out.println(accounts.get(request[1]));

                default:
                    writer.println("NEPOSTOJECI_ZAHTEV");
                    writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
