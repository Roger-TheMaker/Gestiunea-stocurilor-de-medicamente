package Ierarhia;

import java.util.Objects;

public class Medicament {
    private  int cod_Medicament;
    private  String nume_Medicament;
    private  String tip_Medicament;
    public Medicament(int cod, String nume , String tip){
        this.cod_Medicament=cod;
        this.nume_Medicament=nume;
        this.tip_Medicament=tip;
    }

    public String getNume() {
        return nume_Medicament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicament that = (Medicament) o;
        return cod_Medicament == that.cod_Medicament &&
                Objects.equals(nume_Medicament, that.nume_Medicament) &&
                Objects.equals(tip_Medicament, that.tip_Medicament);
    }

}
