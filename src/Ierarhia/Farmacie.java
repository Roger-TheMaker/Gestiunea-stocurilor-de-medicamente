package Ierarhia;

import java.util.ArrayList;

public class Farmacie {
    private  int id_Farmacie;
    private  String nume_Farmacie;
    private  String adresa_Farmacie;
    private  String telefon_Farmacie;
    private  ArrayList<Medicament> stoc_de_medicamente;
    public Farmacie(int id, String nume, String adresa, String telefon, ArrayList<Medicament> stoc){
        this.id_Farmacie=id;
        this.nume_Farmacie=nume;
        this.adresa_Farmacie=adresa;
        this.telefon_Farmacie=telefon;
        this.stoc_de_medicamente=stoc;
    }

    public String getNume() {
        return nume_Farmacie;
    }

    public ArrayList<Medicament> getStoc() {
        return stoc_de_medicamente;
    }
}
