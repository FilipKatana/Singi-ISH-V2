import rs.singidunum.banka.Korisnik;
import rs.singidunum.banka.zapisi.Racun;
import rs.singidunum.banka.zapisi.Transakcija;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket socky = new ServerSocket(3000)) {
            //Socket socket = socky.accept();
            Racun rac = new Racun(new Korisnik("Marina", "Marić"));
            Racun racc = new Racun(new Korisnik("Sara", "Mitrović"), 10000);

            Transakcija trans = new Transakcija(rac, racc, 5000);
            Transakcija trans2 = new Transakcija(racc, rac, 2000);

        } catch (IOException e) {
            System.out.println("Greška!!");
        }
    }
}