package View;

import Domain.Boli;
import Domain.CitireDInFisier;
import Domain.Medicament;
import Domain.Pacient;
import Service.PacientService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Consola {
    private final PacientService pacientService;
    private final Scanner scanner = new Scanner(System.in);


    public Consola(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    public void citirePacientDeLaTastatura()  {
        boolean isTrue=true;
        while (isTrue) {
            try {
                System.out.println("Dati CNP ul: ");
                int CNP = scanner.nextInt();
                System.out.println("Dati Numele: ");
                String nume = scanner.next();
                System.out.println("Dati Prenumele: ");
                String prenume = scanner.next();
                System.out.println("Dati Varsta: ");
                int varsta = scanner.nextInt();
                System.out.println("Dati adresa: ");
                String adresa = scanner.next();
                System.out.println("Dati SEXUL: ");
                char sex = scanner.next().charAt(0);
                System.out.println("Dati un nume de Boala");
                String denumireBoala = scanner.next();
                System.out.println("datu un cod de Boala");
                int codDeBoala = scanner.nextInt();
                System.out.println("Pacientul a fost Consultat? ");
                String aFostConsultat = scanner.next();
                boolean booleanValue = Boolean.parseBoolean(aFostConsultat);

                Boli boala = new Boli(denumireBoala, null);
                Pacient pacient = new Pacient(CNP, nume, prenume, varsta, adresa, sex, boala, booleanValue);
                this.pacientService.addPacient(pacient);
                isTrue=false;

            } catch (InputMismatchException e) {
                System.out.println("Eroare," + e);
            }

        }

    }

    public void meniu() {
        System.out.println("1. Afisare Toti pacient");
        System.out.println("2. Adauga pacient");
        System.out.println("3. Afisati Pacientii Neconsultati");
        System.out.println("4. Afisati pacientii consultati");
        System.out.println("5. Sterge pacientul din Lista!");
        System.out.println("6. Afisare pe varsta");
        System.out.println("7. Consultare Pacient");
        System.out.println("8. Afisare Boli Si Medicamente");
        System.out.println("9. Consult Pacient AI");

    }

    public void runMeniu() {
        boolean exit = true;
        while (exit) {
            meniu();
            int optiune = scanner.nextInt();
            switch (optiune) {
                case 1:
                    afisarePacienti();
                    break;
                case 2:
                    citirePacientDeLaTastatura();
                    break;
                case 3:
                    afisarePacientiNeconsultati();
                    break;
                case 4:
                    afisarePacientiConsultati();
                    break;
                case 5:
                    stergerePacient();
                    break;
                case 6:
                    afisarePeVarsta();
                    break;
                case 7:
                    try {
                        consultaPacient();
                    } catch (NullPointerException E) {
                        System.out.println("Nu exista Acest CNP in SISTEM");
                        runMeniu();
                    }
                    break;
                case 8:
                    afisareMedicamentSiBOliConsola();
                    break;
                case 9:
                    consultPacientAI();
                    break;

                case 0:
                    exit = false;
                    break;
            }
        }
    }

    public void stergerePacient(){
        System.out.println("Introduce CNP ul persoanei care vrei sa stergi: ");
        int cnp = scanner.nextInt();
        if (pacientService.stergePacientService(cnp)){
            System.out.println("Pacientul a fost sters !");
        }else System.out.println("Nu se gaseste pacientul in lista, verifica datele");

    }

    public void afisarePacienti() {
        if (pacientService.getAllPacient().isEmpty()) {
            CitireDInFisier.citireTotDinFisier(pacientService);
        }

        for (Pacient pacient : this.pacientService.getAllPacient()) {
            System.out.println(pacient.getCNP() + "  |" + pacient.getNume() + "   | " + pacient.getPrenume() + "  | " + pacient.getVarsta() + "   |  " + pacient.getAdresa() + "     |  " + pacient.getSex() + "  |  " + pacient.getDenumireBoala() + pacient.getDenumireBoala().getMedicamenteCompatibile() + "  |   " + "    |  " + pacient.getConsultat());
        }
    }

    // Incercare#1
//    public void afisareBoliCuMedicamente(){
//        if (pacientService.getAllBoli().isEmpty()){
//            CitireDInFisier.citireTotDinFisier(pacientService);
//        }
//        for (Boli boala: this.pacientService.getAllBoli()){
//            System.out.println(boala);
//            for (Medicament medicamente: boala.getMedicamenteCompatibile()){
//                System.out.print(boala + " " + medicamente + " spatiu medicament ");
//            }
//        }
//    }
    private void afisarePacientiNeconsultati() {
        if (pacientService.getAllPacient().isEmpty()) {
            CitireDInFisier.citireTotDinFisier(pacientService);
        }

        for (Pacient pacient : this.pacientService.getAllPacient()) {
            if (!(pacient.getConsultat())) {
                System.out.println(pacient.getCNP() + "  |" + pacient.getNume() + "   | " + pacient.getPrenume() + "  | " + pacient.getVarsta() + "   |  " + pacient.getAdresa() + "     |  " + pacient.getSex() + "  |  " + pacient.getDenumireBoala() + "    |  " + pacient.getConsultat());
            }
        }
    }

    private void afisarePacientiConsultati() {

        for (Pacient pacient : this.pacientService.getAllPacient()) {
            if (pacient.getConsultat()) {
                System.out.println(pacient.getCNP() + "  |" + pacient.getNume() + "   | " + pacient.getPrenume() + "  | " + pacient.getVarsta() + "   |  " + pacient.getAdresa() + "     |  " + pacient.getSex() + "  |  " + pacient.getDenumireBoala() + "    |  " + pacient.getDenumireBoala().getMedicamenteCompatibile() + "  |   " + pacient.getConsultat());
            }
        }
    }

    private void afisarePeVarsta() {
        System.out.println("\t\t\t" + "PACIENTI CU VARSTA INTRE: 0-1 ANI" + "\n");
        afisarePacientPeVarsta(0, 1);
        System.out.println();
        System.out.println("\t\t\t" + "PACIENTI CU VARSTA INTRE: 2-4 ANI" + "\n");
        afisarePacientPeVarsta(2, 4);
        System.out.println();
        System.out.println("\t\t\t" + "PACIENTI CU VARSTA INTRE: 5-10 ANI" + "\n");
        afisarePacientPeVarsta(5, 10);
        System.out.println();
        System.out.println("\t\t\t" + "PACIENTI CU VARSTA INTRE: 11-18 ANI" + "\n");
        afisarePacientPeVarsta(11, 18);
        System.out.println();
        System.out.println("\t\t\t" + "PACIENTI CU VARSTA INTRE: 19-59 ANI" + "\n");
        afisarePacientPeVarsta(19, 59);
        System.out.println();
        System.out.println("\t\t\t" + "PACIENTI CU VARSTA PESTE 60 ANI" + "\n");
        afisarePacientPeVarsta(60, 120);
    }

    public void afisarePacientPeVarsta(int deLaVarsta, int panaLaVarsta) {
        for (Pacient pacient : this.pacientService.getAllPacient()) {
            if (pacient.getVarsta() >= deLaVarsta && pacient.getVarsta() <= panaLaVarsta) {
                System.out.println(pacient.getCNP() + "  |" + pacient.getNume() + "   | " + pacient.getPrenume() + "  | " + pacient.getVarsta() + "   |  " + pacient.getAdresa() + "     |  " + pacient.getSex() + "  |  " + pacient.getDenumireBoala() + "    |  " + pacient.getConsultat());
            }
        }
    }

    public void consultaPacient() {
        System.out.println("Da CNP-ul pacientului pe care vrei sa updatezi: ");
        int cnpPacientUpdatat = scanner.nextInt();
        System.out.println("Introduceti medicamentul pacientului");
        String denumireMedicament1 = scanner.next();
        String denumireMedicament2 = scanner.next();
        List<Medicament> medicamenteDupaConsult = new ArrayList<>();
        Medicament medicamentCOnsultat = new Medicament(denumireMedicament1);
        Medicament medicamentCOnsultat2 = new Medicament(denumireMedicament2);

        medicamenteDupaConsult.add(medicamentCOnsultat);
        medicamenteDupaConsult.add(medicamentCOnsultat2);
        System.out.println("Introduce Boala Pacientului: ");
        String denumireBoala = scanner.next();
        boolean aFostConsultat = true;

        this.pacientService.consultarePacientService(cnpPacientUpdatat, aFostConsultat, medicamenteDupaConsult, denumireBoala);
    }

    public void consultPacientAI() { //in functie de boala
        System.out.println("Da CNP-ul pacientului pe care vrei sa updatezi cu ajutorul Inteligentei Artificiale ^_^ sau 0 pentru meniu ");
        int cnpPacientUpdatat = scanner.nextInt();
        if (cnpPacientUpdatat == 0) {
            runMeniu();
        }
        System.out.println("BoalaPacientului");
        String boalaAi = scanner.next();
        boolean aFostConsultat = true;
        boolean exista = this.pacientService.consultarePacientAI(cnpPacientUpdatat, boalaAi, aFostConsultat);

        if (!exista) {
            System.out.println("Nu exista aceasta boala in baza de date");
            consultPacientAI();
        }


    }

    public void afisareMedicamentSiBOliConsola() {
        this.pacientService.afisareBoliSiMedicamenteService();
    }
}


