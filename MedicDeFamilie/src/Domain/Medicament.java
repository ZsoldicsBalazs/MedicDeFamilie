package Domain;

public class Medicament {
    private String nume;

    public Medicament(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }


}
