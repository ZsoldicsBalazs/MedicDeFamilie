package Domain;

import Service.PacientService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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

            for (int i = 0; i < nrPacienti; i++) {
                String linieCurenta = bufferedReader.readLine();
                String[] atribute = linieCurenta.split(",");
                int id = Integer.parseInt(atribute[0]);
                int CNP = Integer.parseInt(atribute[1]);
                String nume = atribute[2];
                String prenume = atribute[3];
                int varsta = Integer.parseInt(atribute[4]);
                String adresa = atribute[5];
                String sex = atribute[6];
                char sexChar = sex.charAt(0);
                String numeBoala = atribute[7];
                Boli boala = new Boli(numeBoala, null);
                boolean consultat = Boolean.parseBoolean(atribute[8]);
                listaPacient[i] = new Pacient(id,CNP, nume, prenume, varsta, adresa, sexChar, boala, consultat);
                pacientService.addPacient(listaPacient[i]);
            }

        } catch (Exception eroareeeeeee) {
            System.out.println(eroareeeeeee);
        }
    }

    public static void citireMedicamente(BufferedReader bufferedReader, PacientService pacientService) {
        try {
            int nrBoli = Integer.parseInt(bufferedReader.readLine());
            Boli[] listaBoli = new Boli[nrBoli];
            for (int i = 0; i < listaBoli.length; i++) {
                String linieCurenta = bufferedReader.readLine();
                String[] atribute = linieCurenta.split(",");
                String numeBoala = atribute[0];
                String numeMedicament1 = atribute[1];
                String numeMedicament2 = atribute[2];
                List<Medicament> listaMedicament = new ArrayList<>();
                listaMedicament.add(new Medicament(numeMedicament1));
                listaMedicament.add(new Medicament(numeMedicament2));
                listaBoli[i] = new Boli(numeBoala, listaMedicament);
                pacientService.addBoli(listaBoli[i]);
            }


        } catch (Exception E) {
            System.out.println("lipsa citire medicamente");

        }
    }

}
