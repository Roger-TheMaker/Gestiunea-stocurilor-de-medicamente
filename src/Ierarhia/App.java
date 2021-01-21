package Ierarhia;

import sqlite.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    private ArrayList<Oras> lista_orase;
    public App(ArrayList<Oras> lista){
        this.lista_orase=lista; //lasam asa deocamdata, trebuie sa ne legam de faptul ca stim exact care sunt orasele
    }

    public void afiseaza_farmacii_cu_medicament_pe_stoc(Medicament medicament_anume) {
       /* for(Oras oras: lista_orase) {
            for(Farmacie farmacie: oras.getFarmacii() ) {
                for(Medicament medicament: farmacie.getStoc()){
                    if (medicament.equals(medicament_anume))
                        System.out.println(farmacie + "");
                }
            }
        }
        */
        for(Oras oras: lista_orase) {

            Connection conn = Connect.connect("database.db");
            ResultSet rs = null;

            String sql_command = "SELECT * FROM farmacii WHERE  stoc = " + "\'" + medicament_anume.getNume() + "\' and " +
                    "nume=" + "\'" + oras.getNume_Oras() + "\'";

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql_command);
                rs = pstmt.executeQuery();

                while (rs.next()) {

                    String nume_oras = rs.getString("nume");
                    String sql_command2 = "SELECT * FROM oras WHERE  stoc = " + "\'" + medicament_anume.getNume() + "\'";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Connect.closeConnection();
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void afiseaza_farmacii_pentru_un_oras_anume(Oras oras){
        oras.afiseaza_farmacii_pentru_oras();
    }

    public void afiseaza_cantitate_totala_de_medicament_pentru_un_oras_anume(Medicament medicament, Oras oras){
        oras.afiseaza_cantitate_totala_dintr_un_medicament_oras(medicament);
    }
}
