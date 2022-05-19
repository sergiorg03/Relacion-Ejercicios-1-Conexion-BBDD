package com.mycompany.relacion_ejercicios1_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {

    public static void main(String[] args) {
    
        try {
            
            String cadcon = "jdbc:mysql://localhost/empresa?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(cadcon, user, password);
            
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("Select * from empleados order by numem desc");
            
            while (resultado.next()) {
                
                int numEm = resultado.getInt(1);
                int extel = resultado.getInt(2);
                String Fecna = resultado.getString(3);
                String Fecin = resultado.getString(4);
                double salar = resultado.getDouble(5);
                int comis = resultado.getInt(6);
                int numhij = resultado.getInt(7);
                String nomem = resultado.getString(8);
                int NumDe = resultado.getInt(9);
                
                System.out.println(numEm +"\t "+ extel +"\t "+ Fecna +"\t "+ Fecin +"\t "+ salar +"\t "+ comis +"\t "+ numhij +"\t "+ nomem +"\t "+ NumDe);
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}