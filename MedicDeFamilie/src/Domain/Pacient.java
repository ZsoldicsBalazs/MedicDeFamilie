package Domain;

public class Pacient {
    private int CNP;
    private String nume;
    private String prenume;
    private int varsta;
    private String adresa;
    private char sex;
    private Boli denumireBoala;
    private Boolean consultat;


    public Pacient(int CNP, String nume, String prenume, int varsta, String adresa, char sex, Boli boalacurenta, boolean consultat)  {
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.adresa = adresa;
        this.sex = sex;
        this.denumireBoala = boalacurenta;
        this.consultat = consultat;
    }

    public Boolean getConsultat() {
        return consultat;
    }

    public void setConsultat(Boolean consultat) {
        this.consultat = consultat;
    }

    public Boli getDenumireBoala() {
        return denumireBoala;
    }

    public void setDenumireBoala(Boli denumireBoala) {
        this.denumireBoala = denumireBoala;
    }

    public int getCNP() {
        return CNP;
    }
//
//    @Override
//    public String toString() {
//        return  CNP +
//                "   |   " + nume +
//                "   |   " + prenume +
//                "   |   " + varsta +
//                "   |   " + adresa +
//                "          |   " + sex +
//                "   |   " + denumireBoala +
//                "   |   " +denumireBoala.getMedicamenteCompatibile()+
//                "   |   " + consultat;
//    }

    public void setCNP(int CNP) {
        this.CNP = CNP;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) throws Exception {

            if (varsta>0 && varsta<125) {
                this.varsta = varsta;
            }else throw new Exception("VarstaNu E VALIDA");


    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}

