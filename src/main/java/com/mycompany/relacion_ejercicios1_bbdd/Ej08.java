package com.mycompany.relacion_ejercicios1_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ej08 {

    public static void main(String[] args) {
        
        try {
            
            String cadcon = "jdbc:mysql://localhost/empresa?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(cadcon, user, password);
            
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("Select nomem from empleados WHERE numde IN (SELECT numde FROM empleados WHERE nomem = 'DOROTEA' or nomem = 'PILAR') ORDER BY nomem ASC;");
            
            System.out.println("NOMBRE");
            System.out.println("---------");
            
            while (resultado.next()) {
                
                String nomem = resultado.getString(1);
                
                System.out.println(nomem );
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
