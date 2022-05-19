package com.mycompany.relacion_ejercicios1_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ej06 {

    public static void main(String[] args) {
    
        try {
            
            String cadcon = "jdbc:mysql://localhost/empresa?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(cadcon, user, password);
            
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("Select salar, nomem from empleados WHERE NUMHI = 0 AND salar > 1200 And salar < 1500 ORDER BY salar desc, nomem desc;");
            
            System.out.println("NUMEM\tNOMEM");
            
            while (resultado.next()) {
                
                int salario = resultado.getInt(1);
                String nomem = resultado.getString(2);
                
                System.out.println(salario +"\t "+ nomem);
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}