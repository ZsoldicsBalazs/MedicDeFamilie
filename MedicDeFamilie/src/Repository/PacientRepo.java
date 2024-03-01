package Repository;
import Domain.Boli;
import Domain.Pacient;
import Domain.Medicament;
import java.util.*;

public class PacientRepo {

    private final List<Pacient> pacienti = new ArrayList<>();
    private final List<Medicament> medicamente = new ArrayList<>();
    private final List<Boli> bolile = new ArrayList<>();


    public PacientRepo adaugaBoli (Boli boala){
        boolean isIn = false;
        for (Boli b : bolile) {
            if (Objects.equals(b.getNumeBoala(), boala)) {
                isIn = true;
            }
        }

        if (!isIn) {
            this.bolile.add(new Boli(boala.getNumeBoala(),boala.getMedicamenteCompatibile()));
        }

        return this;
    }
    public Pacient cautaPacientCNP(int CNP){
        for (Pacient pacientCurent: this.pacienti){
            if (CNP == pacientCurent.getCNP()){
                return pacientCurent;
            }
        }return null;
    }

    public Pacient adaugaPacientiRepository(Pacient pacient){
        if(cautaPacientCNP(pacient.getCNP())==null){
            this.pacienti.add(pacient);
            return pacient;
        }
        return null;
    }
    public boolean stergerePacientRepo(Pacient pacient){
        try {
            if (pacienti.remove(cautaPacientCNP(pacient.getCNP()))){
                return true;
            }

        }catch (NullPointerException E){
            System.out.println();

        }
        return false;
    }
public List<Boli> getAllBoli(){
        return this.bolile;
}
public List<Medicament> getAllMedicamente(){
        for (Boli boli: bolile){
           return boli.getMedicamenteCompatibile();
        }
    return null;
}
    public List<Pacient> getAllPacienti(){
        pacienti.sort(Comparator.comparing(Pacient::getNume));          //sortam dupa numele pacientilor
        return this.pacienti;                                           //returneaza lista cu pacienti
    }

    // functie care cauta si returneaza pacientul dupa CNP, si updateaza consultatia!

    public PacientRepo updatePacient (Pacient pacientDeUpdatat){
        for(int i=0; i<this.pacienti.size();i++){
            if (this.pacienti.get(i).getCNP()==pacientDeUpdatat.getCNP()){
              this.pacienti.get(i).setConsultat(pacientDeUpdatat.getConsultat());
              this.pacienti.get(i).setDenumireBoala(pacientDeUpdatat.getDenumireBoala());
              return this;
            }
        }
        return null;
    }



}
