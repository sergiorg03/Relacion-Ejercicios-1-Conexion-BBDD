package com.mycompany.relacion_ejercicios1_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ej10 {

    public static void main(String[] args) {
        try {
            
            String cadcon = "jdbc:mysql://localhost/empresa?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(cadcon, user, password);
            
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("Select nomde, avg(salar), min(salar), max(salar) FROM empleados, departamentos WHERE departamentos.numde = empleados.numde GROUP BY nomde;");
            
            System.out.println("NOMBRE DEP\t\tMEDIA SALARIO\tSALARIO MINIMO\tSALARIO MAXIMO");
            System.out.println("-----------\t\t-------------\t--------------\t--------------");
            
            while (resultado.next()) {
                
                String nomde = resultado.getString(1);
                int salario = resultado.getInt(2);
                int salario2 = resultado.getInt(3);
                int salario3 = resultado.getInt(4);
                
                System.out.println(nomde +"\t"+ salario +"\t\t"+ salario2 +"\t\t"+ salario3);
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}