package rs.singidunum.banka.zapisi;

import rs.singidunum.banka.Korisnik;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Racun {
    private Korisnik korisnik;
    private ArrayList<Transakcija> prethodneTransakcije;
    private long suma;

    private Semaphore semaphore;

    public Racun(Korisnik korisnik, long suma) {
        this.suma = suma;
        this.prethodneTransakcije = new ArrayList<Transakcija>();
        this.korisnik = korisnik;
        this.semaphore = new Semaphore(1);
    }

    public Racun(Korisnik korisnik) {
        this(korisnik, 0);
    }

    public Transakcija getTransakcija(int index) {
        return prethodneTransakcije.get(index);
    }

    void novaTransakcija(Transakcija t) {
        semaphore.acquireUninterruptibly();
        prethodneTransakcije.add(t);
        semaphore.release();
    }

    public long getSuma() {
        long result = suma;
        for (int i = 0; i < prethodneTransakcije.size(); ++i) {
            if (prethodneTransakcije.get(i).getPosiljalac() == this) {
                result -= prethodneTransakcije.get(i).getSuma();
            } else {
                result += prethodneTransakcije.get(i).getSuma();
            }
        }
        return result;
    }

    public String toString() {
        return "Račun vrednosti: " + getSuma() + ", Korisnik: " + this.korisnik;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }
}
