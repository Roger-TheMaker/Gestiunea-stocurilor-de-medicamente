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
        this.lista_orase=lista;
    }
    public void afiseaza_farmacii_cu_medicament_pe_stoc(Medicament medicament_anume){
    //netestat, probabil aceasta metoda nu va functiona corespunzator

        //Ar trebui sa parcurgem lista de orase si pentru fiecare oras sa parcurgem lista de farmacii si sa verificam
        //in lista medicamente daca exista medicamentul respectiv, acel medicament anume
        for(Oras oras: lista_orase) {

            Connection conn = Connect.connect("database.db");

            ResultSet rs = null;
            String sql_command = "SELECT lista_de_farmacii FROM oras WHERE nume = " + "\'" + oras.getNume_Oras() + "\' INNER JOIN farmacii ON " +
                    " farmacii.nume_oras = oras.lista_de_farmacii  WHERE  stoc = " + "\'" + medicament_anume.getNume() + "\'";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql_command);
                rs = pstmt.executeQuery();

                while (rs.next()) {

                    ResultSet rs2 = null;

                    int id_farmacie = rs.getInt("id");

                    String sql_command2 = "SELECT * FROM farmacii WHERE  id = id_farmacie";

                    try {

                        PreparedStatement pstmt2 = conn.prepareStatement(sql_command2);
                        rs2 = pstmt2.executeQuery();

                        while (rs2.next()) {

                            int id = rs2.getInt("id");
                            String nume = rs2.getString("nume");
                            String nume_oras = rs2.getString("nume_oras");
                            String adresa = rs2.getString("adresa");
                            String telefon = rs2.getString("telefon");
                            System.out.println(id + " " + nume + " " + nume_oras + " " + adresa + "" + telefon);
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
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
