package com.mycompany.relacion_ejercicios1_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListinTelf {

    public static void main(String[] args) {
        try {
            
            String cadcon = "jdbc:mysql://localhost/empresa?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(cadcon, user, password);
            
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("Select numem, extel, nomem from empleados WHERE NUMDE = 121 ORDER BY NOMEM ASC");
            
            System.out.println("NUMEM\tEXTEL\tNOMEM");
            
            while (resultado.next()) {
                
                int numEm = resultado.getInt(1);
                int extel = resultado.getInt(2);
                String nomem = resultado.getString(3);
                
                System.out.println(numEm +"\t "+ extel +"\t "+ nomem);
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}