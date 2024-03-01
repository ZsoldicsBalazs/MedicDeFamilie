package Domain;

import Repository.PacientRepo;
import Service.PacientService;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class CitireDInFisier {

    public static void citireTotDinFisier(PacientService pacientService) {
        try {
            String filePath = "D:\\Algoritmica\\Teme\\MedicDeFamilie\\MedicDeFamilie\\src\\pacienti.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            pacientiCititeDinFisier(bufferedReader, pacientService);
            citireMedicamente(bufferedReader, pacientService);
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void pacientiCititeDinFisier(BufferedReader bufferedReader, PacientService pacientService) {
        try {
            int nrPacienti = Integer.parseInt(bufferedReader.readLine());
            Pacient[] listaPacient = new Pacient[nrPacienti];

            for (int i=0;i<nrPacienti;i++) {
                String linieCurenta = bufferedReader.readLine();
                String[] atribute = linieCurenta.split(",");
                int CNP = Integer.parseInt(atribute[0]);
                String nume = atribute[1];
                String prenume = atribute[2];
                int varsta = Integer.parseInt(atribute[3]);
                String adresa = atribute[4];
                String sex = atribute[5];
                char sexChar = sex.charAt(0);
                String numeBoala = atribute[6];
                Boli boala =new Boli(numeBoala,null);
                Boolean consultat = Boolean.parseBoolean(atribute[7]);
                listaPacient[i] = new Pacient(CNP,nume, prenume, varsta, adresa, sexChar, boala, consultat);
                pacientService.addPacient(listaPacient[i]);
            }

        } catch (Exception eroareeeeeee) {
            System.out.println(eroareeeeeee);
        }
    }

    public static void citireMedicamente(BufferedReader bufferedReader, PacientService pacientService)  {
        try {
            int nrBoli = Integer.parseInt(bufferedReader.readLine());
            Boli [] listaBoli = new Boli[nrBoli];
            for (int i=0; i<listaBoli.length;i++){
                String linieCurenta = bufferedReader.readLine();
                String[] atribute = linieCurenta.split(",");
                String numeBoala = atribute[0];
                String numeMedicament1 = atribute[1];
                String numeMedicament2=atribute[2];
                List<Medicament> listaMedicament = new ArrayList<>();
                listaMedicament.add(new Medicament(numeMedicament1));
                listaMedicament.add(new Medicament(numeMedicament2));
                listaBoli[i] = new Boli(numeBoala,listaMedicament);
                pacientService.addBoli(listaBoli[i]);
            }


        } catch (Exception E){
            System.out.println("lipsa citire medicamente");

        }
    }

}
