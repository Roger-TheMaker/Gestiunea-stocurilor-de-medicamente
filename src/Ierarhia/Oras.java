package Ierarhia;

import sqlite.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//fiecare oras ar trebui sa fie capabil sa isi indeplineasca singur aceste doua functionalitati

public class Oras {
    private String nume_Oras;
    private ArrayList<Farmacie> farmacii_Oras;

    public String getNume_Oras(){
        return this.nume_Oras;
    }

    /*
    Avand in vedere ca nu este necesar sa ne cream tabelele si sa ne inseram direct din Java/Intellij
    inregistrarile, putem folosi o altfel de abordare
     */

    public  Oras(String nume, ArrayList<Farmacie> farmacii){
       this.farmacii_Oras=farmacii;
       this.nume_Oras=nume;
    }

    public ArrayList<Farmacie> getFarmacii() {
        return farmacii_Oras;
    }

    public void afiseaza_farmacii_pentru_oras(){

        // Set<String> lista_de_nume_a_farmaciilor = farmacii_Oras.stream().map(Farmacie::getNume).collect(Collectors.toSet());
        // System.out.println(lista_de_nume_a_farmaciilor);
        //for(String numefarmacie: lista_de_nume_a_farmaciilor){
        //nu e bine, trebuie sa fac referinta la oras in SQL, cumva

            Connection conn = Connect.connect("database.db");

            String sql_command = "SELECT * FROM farmacii WHERE nume= "+ "\'" + this.nume_Oras + "\'";

            ResultSet rs = null;
            try {
                PreparedStatement pstmt  = conn.prepareStatement(sql_command);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    String ceva1 = rs.getString("nume");
                    String ceva2 = rs.getString("adresa");
                    System.out.println(ceva1 + " " + ceva2);
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

    public int afiseaza_cantitate_totala_de_medicamente_oras(Medicament medicament_anume){
        int count=0;
        Connection conn = Connect.connect("database.db");

        String sql_command = "SELECT * FROM farmacii WHERE  stoc = " + "\'" + medicament_anume.getNume() + "\' and " +
                "nume=" + "\'" + this.nume_Oras + "\'";

        ResultSet rs = null;
        try {
            PreparedStatement pstmt  = conn.prepareStatement(sql_command);
            rs = pstmt.executeQuery();

            while (rs.next()) {
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
