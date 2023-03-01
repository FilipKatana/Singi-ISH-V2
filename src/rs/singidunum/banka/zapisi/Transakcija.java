package rs.singidunum.banka.zapisi;

import rs.singidunum.banka.zapisi.Racun;

public class Transakcija {
    private Racun primalac;
    private Racun posiljalac;
    private long suma;

    public Transakcija(Racun primalac, Racun posiljalac, long suma) {
        this.primalac = primalac;
        this.posiljalac = posiljalac;
        this.suma = suma;

        posiljalac.novaTransakcija(this);
        primalac.novaTransakcija(this);
    }

    public long getSuma() {return this.suma;}

    public Racun getPrimalac() {
        return primalac;
    }

    public Racun getPosiljalac() {
        return posiljalac;
    }

    public String toString() {
        return "Pošiljalac: " + posiljalac.getKorisnik() +
                ", Primalac: " + primalac.getKorisnik() + ", Suma: " + suma;
    }
}
