package com.mycompany.relacion_ejercicios1_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Delete {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);

        try {

            String cadcon = "jdbc:mysql://localhost/empresa?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(cadcon, user, password);

            System.out.println("Introduzca el NUMEM del empleado a borrar: ");
            int numEm1 = leer.nextInt();

            PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM empleados WHERE NUMEM = (?)");

            pstmt.setInt(1, numEm1);

            int rowsInserted = pstmt.executeUpdate(); //Numero de líneas afectadas por el Insert

            PreparedStatement pstmtSelect = conexion.prepareStatement("SELECT * FROM empleados;");
            
            //IMPORTANTE: El PreparedStatement y ExecuteStatement se usan cuando hagamos Insert, Update, Delete, Create, Drop o Alter.
            
            System.out.println("Número de lineas afectadas: " + rowsInserted);

            ResultSet resultado = pstmtSelect.executeQuery();

            while (resultado.next()) {

                //Mapeo
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
            pstmt.close();
            pstmtSelect.close();
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}