/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class Problema3 {

    static String url = "jdbc:mysql://localhost:3306/programacion2223";
    static String user = "root";
    static String password = "";
    static PreparedStatement ps;
    static ResultSet rs;
    static File f = new File("notas.txt");
    static String id;
    static String nota;
    static boolean subido;

    public static void main(String[] args) {

        /**
         * Leo el archivo notas.txt y me conecto a la BD, mientras la linea que
         * lea, no es nula, separo el id de la nota, compruebo si el id_alumno
         * existe en la BD, se le notificara de que las notas ya estan subidas
         * si no es asi, compruebo si la nota es mayor o igual a 5, inserto las
         * notas en la BD, y luego compruebo todas las notas, y las que sean
         * matriculas de honor, mostrara el id y la nota.
         */
        try (BufferedReader br = new BufferedReader(new FileReader(f)); Connection conn = conBD()) {

            String linea = null;

            while ((linea = br.readLine()) != null) {
                String[] separacion = linea.split(":");
                id = separacion[0];
                nota = separacion[1];

                ps = conn.prepareStatement("SELECT * FROM aprobados WHERE id_alumno = ?");
                ps.setInt(1, Integer.parseInt(id));
                rs = ps.executeQuery();

                if (rs.next()) {
                    subido = false;

                } else {
                    if (Double.parseDouble(nota) >= 5) {
                        ps = conn.prepareStatement("INSERT INTO aprobados (id_alumno, nota) VALUES(?,?)");
                        ps.setInt(1, Integer.parseInt(id));
                        ps.setDouble(2, Double.parseDouble(nota));
                        ps.executeUpdate();
                        subido = true;
                    }
                }

            }

            if (subido) {
                System.out.println("Notas subidas a la BD");
            } else {
                System.out.println("Las notas ya estan subidas");
            }

            ps = conn.prepareStatement("SELECT * FROM aprobados WHERE nota >=9");
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("PROPUESTAS A MATRICULAS DE HONOR: \n id_alumno: " + rs.getInt("id_alumno") + "\n nota: " + rs.getDouble("nota"));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problema3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Problema3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection conBD() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
