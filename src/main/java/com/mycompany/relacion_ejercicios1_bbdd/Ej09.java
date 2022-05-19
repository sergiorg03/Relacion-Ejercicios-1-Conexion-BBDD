package com.mycompany.relacion_ejercicios1_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ej09 {

    public static void main(String[] args) {
    
        try {
            
            String cadcon = "jdbc:mysql://localhost/empresa?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(cadcon, user, password);
            
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("Select nomem, salar FROM empleados HAVING salar > salar*0.4 ORDER BY nomem ASC;");
            
            System.out.println("NOMBRE\t\tSALARIO TOTAL");
            System.out.println("---------------  ------------");
            
            while (resultado.next()) {
                
                String nomem = resultado.getString(1);
                int salario = resultado.getInt(2);
                
                System.out.println(nomem +"\t\t "+ salario);
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}