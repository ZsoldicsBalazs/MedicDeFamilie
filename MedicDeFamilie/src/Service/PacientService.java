package Service;
import Domain.Boli;
import Domain.Medicament;
import Domain.Pacient;
import Repository.PacientRepo;
import java.util.List;

public class PacientService {
    private final PacientRepo pacientRepo;

    public PacientService(PacientRepo pacientRepo) {
        this.pacientRepo = pacientRepo;
    }

    public void addPacient(Pacient pacient){
        pacientRepo.adaugaPacientiRepository(pacient);

    }
    public void addBoli(Boli boala) {
        pacientRepo.adaugaBoli(boala);
    }
    public boolean stergePacientService(int cnp){
        Pacient pacientDeSters = pacientRepo.cautaPacientCNP(cnp);
        return pacientRepo.stergerePacientRepo(pacientDeSters);
    }
    public List<Boli> getAllBoli(){
        return this.pacientRepo.getAllBoli();
    }
    public List<Medicament> getAllMedicament(){
        return this.pacientRepo.getAllMedicamente();
    }

    public List<Pacient> getAllPacient(){
        return this.pacientRepo.getAllPacienti();
    }

    public void consultarePacientService(int CNP, boolean consultat, List <Medicament> medicamente, String boala){
    Pacient deUpdatat = pacientRepo.cautaPacientCNP(CNP);
    Boli boalaPacient = new Boli(boala,medicamente);
    addBoli(boalaPacient);
    boalaPacient.setMedicamenteCompatibile(medicamente);
    deUpdatat.setDenumireBoala(boalaPacient);
    deUpdatat.setConsultat(consultat);
    pacientRepo.updatePacient(deUpdatat);

    }

    public boolean consultarePacientAI(int cnp,String boala, boolean aFostConsultat){
    try {
        if (pacientRepo.cautaPacientCNP(cnp).getCNP()==cnp){
            Pacient newPacient=pacientRepo.cautaPacientCNP(cnp);
            for (Boli boalaCUrenta : getAllBoli()){                     //TODO: de updatat bolile si medicamentele
                if (boalaCUrenta.getNumeBoala().equals(boala)){
                    newPacient.setDenumireBoala(boalaCUrenta);
                    newPacient.setConsultat(aFostConsultat);
                    pacientRepo.updatePacient(newPacient);
                    return true;
                }
            }
        }
    }catch (NullPointerException E){
        System.out.println("Nu am Gasit acest pacient cu CNP ul CAUTAT 11");
        }
        return false;
    }

    public void afisareBoliSiMedicamenteService(){
        for (Boli boala: getAllBoli()) {
            System.out.println(boala.getNumeBoala()+ " --> "+boala.getMedicamenteCompatibile());
        }

    }

    private String toString(List<Medicament> medicamenteCompatibile) {
        return medicamenteCompatibile.toString();
    }


}
