import Domain.Boli;
import Domain.Pacient;
import Repository.PacientRepo;
import Service.PacientService;
import View.Consola;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PacientRepo pacientRepo = new PacientRepo();
        PacientService pacientService = new PacientService(pacientRepo);
        Consola consola = new Consola(pacientService);
        consola.runMeniu();


    }
}