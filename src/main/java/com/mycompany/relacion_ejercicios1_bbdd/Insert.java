package com.mycompany.relacion_ejercicios1_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Insert {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        try {

            String cadcon = "jdbc:mysql://localhost/empresa?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(cadcon, user, password);

            System.out.println("NumEm: ");
            int numEm1 = leer.nextInt();
            
            System.out.println("extel");
            int extel1 = leer.nextInt();
            leer.nextLine(); //Limpiar Buffer
            
            System.out.println("Fecna");
            String Fecna1 = leer.nextLine();
            
            System.out.println("Fecin");
            String Fecin1 = leer.nextLine();
            
            System.out.println("salar");
            int salar1 = leer.nextInt();
            
            System.out.println("comis");
            int comis1 = leer.nextInt();
            
            System.out.println("numhij");
            int numhij1 = leer.nextInt();
            leer.nextLine(); //Limpiar Buffer
            
            System.out.println("nomem");
            String nomem1 = leer.nextLine();
            
            System.out.println("NumDe");
            int NumDe1 = leer.nextInt();

            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO empleados VALUES (?,?,?,?,?,?,?,?,?)");

            pstmt.setInt(1, numEm1);
            pstmt.setInt(2, extel1);
            pstmt.setString(3, Fecna1);
            pstmt.setString(4, Fecin1);
            pstmt.setInt(5, salar1);
            pstmt.setInt(6, comis1);
            pstmt.setInt(7, numhij1);
            pstmt.setString(8, nomem1);
            pstmt.setInt(9, NumDe1);

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
