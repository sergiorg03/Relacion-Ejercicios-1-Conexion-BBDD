package com.mycompany.relacion_ejercicios1_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ej12 {

    public static void main(String[] args) {

        try {

            String cadcon = "jdbc:mysql://localhost/empresa?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(cadcon, user, password);

            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT nomde, COUNT(numem), SUM(salar), SUM(comis), SUM(numhi) FROM empleados, departamentos WHERE direc = numem AND tidir = 'F' GROUP BY nomde;");

            System.out.println("NOMDE\t\t\t\tCOUNT(NUMEM)\t\tSUM(SALAR)\t\tSUM(COMIS)\t\tSUM(NUMHI)");
            System.out.println("----------------\t\t------------\t\t-----------\t\t-----------\t\t-----------");

            while (resultado.next()) {

                String nomem = resultado.getString(1);
                int numem = resultado.getInt(2);
                int sum_salar = resultado.getInt(3);
                int sum_comis = resultado.getInt(4);
                int sum_hijos = resultado.getInt(5);

                System.out.println(nomem + "\t\t" + numem + "\t\t\t" + sum_salar + "\t\t\t" + sum_comis + "\t\t\t" + sum_hijos);
            }

            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
