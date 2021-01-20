package Ierarhia;

import java.util.ArrayList;

public class Oras {
    private String nume_Oras;
    private ArrayList<Farmacie> farmacii_Oras;
    public  Oras(String nume, ArrayList<Farmacie> farmacii){
       this.farmacii_Oras=farmacii;
       this.nume_Oras=nume;
    }

    public ArrayList<Farmacie> getFarmacii() {
        return farmacii_Oras;
    }

    public void afiseaza_farmaciile_unui_oras(){
        for(Farmacie farmacie: farmacii_Oras){
                System.out.println(farmacie.getNume() + " ");
        }
    }

    public void afiseaza_cantitate_totala_medicament(Medicament medicament){
        int count=0;
        for(Farmacie farmacie: farmacii_Oras){
            for(Medicament med: farmacie.getStoc()){
                if(med.equals(medicament))
                    count++;
            }
        }
    }
}
