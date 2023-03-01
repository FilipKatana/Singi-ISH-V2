package rs.singidunum.server;

import rs.singidunum.banka.Korisnik;
import rs.singidunum.banka.zapisi.Racun;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

public class Server {
    public static void main(String[] arg) {
        HashMap<String, Racun> accounts = new HashMap<>();
        accounts.put("0909", new Racun(new Korisnik("Zora", "Konjovic"), 6000));
        accounts.put("69", new Racun(new Korisnik("Simeon", "Marić"), 20000));
        accounts.put("556", new Racun(new Korisnik("Šaman", "Jurić"), 9000));
        try (ServerSocket serverSocket = new ServerSocket(3000)) {


            Thread resultDisplay = new Thread(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("NA KRAJU: " + accounts.get("69"));
            });
            resultDisplay.start();


            while (true){
                Thread thread = new Thread(new RequestHandler(serverSocket.accept(), accounts));
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
