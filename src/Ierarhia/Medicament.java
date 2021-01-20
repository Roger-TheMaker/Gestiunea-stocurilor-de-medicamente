package Ierarhia;

import sqlite.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void viewTable(){
        Connection conn = Connect.connect("database.db");
        String sql_command = "SELECT * FROM medicament ";
        ResultSet rs = null;
        try {
            PreparedStatement pstmt  = conn.prepareStatement(sql_command);
            rs = pstmt.executeQuery();

            while (rs.next()) {
             String ceva1 = rs.getString("nume");
             String ceva2 = rs.getString("tip");
             System.out.println(ceva1 + " "+ ceva2);
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
