package Ierarhia;

import sqlite.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//fiecare oras ar trebui sa fie capabil sa isi indeplineasca singur aceste doua functionalitati, aceea de afisare a farmaciilor existente in el
//cat si pe cea de determinare/afisare a celor care au un anumit medicament in stoc

public class Oras {
    private String nume_Oras;
    private ArrayList<Farmacie> farmacii_Oras;

    public String getNume_Oras(){
        return this.nume_Oras;
    }


    public  Oras(String nume, ArrayList<Farmacie> farmacii){
       this.farmacii_Oras=farmacii;
       this.nume_Oras=nume;
    }

    public ArrayList<Farmacie> getFarmacii() {
        return farmacii_Oras;
    }

    public void afiseaza_farmacii_pentru_oras(){

            Connection conn = Connect.connect("database.db");

            String sql_command = "SELECT * FROM farmacii WHERE nume= "+ "\'" + this.nume_Oras + "\'";

            ResultSet rs = null;
            try {
                PreparedStatement pstmt  = conn.prepareStatement(sql_command);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nume = rs.getString("nume");
                    String nume_oras = rs.getString("nume_oras");
                    String adresa = rs.getString("adresa");
                    String telefon = rs.getString("telefon");
                    System.out.println(id + " " + nume + " " + nume_oras + " " + adresa + "" + telefon );
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

    public int afiseaza_cantitate_totala_dintr_un_medicament_oras(Medicament medicament_anume){
        int count=0; //cantitatea de medicament respectiv
        Connection conn = Connect.connect("database.db");

        String sql_command = "SELECT * FROM farmacii WHERE  stoc = " + "\'" + medicament_anume.getCodMedicament() + "\' and " +
                "nume=" + "\'" + this.nume_Oras + "\'";

        ResultSet rs = null;
        try {
            PreparedStatement pstmt  = conn.prepareStatement(sql_command);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                //de fiecare data cand am avut  un nou rand a insemnat ca acea farmacie a avut medicamentul pe stoc.
                count++;
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
        return count;
    }
}
