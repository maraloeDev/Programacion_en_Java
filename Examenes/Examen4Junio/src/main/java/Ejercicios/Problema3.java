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

public class Problema3 {

    static String url = "jdbc:mysql://localhost:3306/programacion2223";
    static String user = "root";
    static String password = "";
    static PreparedStatement ps;
    static ResultSet rs;

    public static void main(String[] args) {
        lecturaFichero();
    }

    private static void lecturaFichero() {

        try (BufferedReader br = new BufferedReader(new FileReader(new File("src\\main\\java\\Enunciados\\notas.txt")))) {

            String linea = null;

            while ((linea = br.readLine()) != null) {
                String[] notasSuperiores = linea.split(":");
                String id = notasSuperiores[0];
                String notas = notasSuperiores[1];

                try (Connection conn = conBD()) {
                    ps = conn.prepareStatement("SELECT * FROM aprobados WHERE id_alumno = ?");
                    ps.setInt(1, Integer.parseInt(id));
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        System.out.println("Las notas ya estan agregadas");
                        return;
                    } else {

                        if (Double.parseDouble(notas) >=5) {
                        ps = conn.prepareStatement("INSERT INTO aprobados (id_alumno, nota) VALUES (?,?)");
                        ps.setInt(1, Integer.parseInt(id));
                        ps.setDouble(2, Double.parseDouble(notas));
                            System.out.println("Notas agregadas");
                        ps.executeUpdate();
                            
                            if(Double.parseDouble(notas) >=9) {
                                
                                Aprobados a = new Aprobados(Integer.parseInt(id), Double.parseDouble(notas));
                                System.out.println(a);
                                
                            }
                            
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Problema3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problema3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Problema3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection conBD() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
