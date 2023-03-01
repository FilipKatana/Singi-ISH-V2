package rs.singidunum.banka;

public class Korisnik {
    private String ime;
    private String prezime;
    private int id;
    private static int curr_id = 0;

    public Korisnik(String ime, String prezime) {
        this.id = curr_id++;
        this.ime = ime;
        this.prezime = prezime;

    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getId() {
        return id;
    }

    public Korisnik() {
        this("Marko", "Nešić");
    }

    public String toString() {
        return "Ime: " + ime + ", Prezime: " + prezime;
    }
}
