package Domain;

import java.util.List;

public class Boli {
    private String numeBoala;
    private List<Medicament> medicamenteCompatibile;

    public Boli(String numeBoala) {
        this.numeBoala = numeBoala;
    }

    @Override
    public String toString() {
        return numeBoala;

    }

    public Boli(String numeBoala, List<Medicament> medicamenteCompatibile) {
        this.numeBoala = numeBoala;
        this.medicamenteCompatibile = medicamenteCompatibile;
    }

    public List<Medicament> getMedicamenteCompatibile() {
        return medicamenteCompatibile;
    }

    public void setMedicamenteCompatibile(List<Medicament> medicamenteCompatibile) {
        this.medicamenteCompatibile = medicamenteCompatibile;
    }

    public String getNumeBoala() {
        return numeBoala;
    }

    public void setNumeBoala(String numeBoala) {
        this.numeBoala = numeBoala;
    }
}
