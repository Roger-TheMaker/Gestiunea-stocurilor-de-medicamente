package Ierarhia;

import java.util.ArrayList;

public class App {
    private ArrayList<Oras> lista_orase;
    public App(ArrayList<Oras> lista){
        this.lista_orase=lista; //lasam asa deocamdata, trebuie sa ne legam de faptul ca stim exact care sunt orasele
    }

    public void afiseaza_farmacii_cu_medicament_pe_stoc(Medicament medicament_anume) {
        for(Oras oras: lista_orase) {
            for(Farmacie farmacie: oras.getFarmacii() ) {
                for(Medicament medicament: farmacie.getStoc()){
                    if (medicament.equals(medicament_anume))
                        System.out.println(farmacie + "");
                }
            }
        }
    }
}
