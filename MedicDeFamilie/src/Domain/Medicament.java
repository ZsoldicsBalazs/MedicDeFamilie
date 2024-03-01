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

//    public Boli getPentruCeBoala() {
//        return pentruCeBoala;
//    }

//    public void setPentruCeBoala(Boli pentruCeBoala) {
//        this.pentruCeBoala = pentruCeBoala;
//        if (pentruCeBoala.getNumeBoala()==)
//    }
    //
    // daca eliquis atunci AVC
    // daca Milgamma atunci avc
    // daca paracetamol atunci raceala
    // daca antibiotic atunci raceala


}
