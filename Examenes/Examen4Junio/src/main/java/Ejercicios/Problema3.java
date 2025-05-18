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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Problema3 {

    static String url = "jdbc:mysql://localhost:3306/programacion2223";
    static String user = "root";
    static String password = "";
    static PreparedStatement ps;
    static ResultSet rs;
    static ArrayList<String> notas = new ArrayList<>();
    static ArrayList<String> ids = new ArrayList<>();

    static File f = new File("src\\main\\java\\Enunciados\\notas.txt");

    public static void main(String[] args) {
        lecturaNotas();
    }

    private static void lecturaNotas() {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] separacion = linea.split(":");
                String id = separacion[0];
                String nota = separacion[1];
                
                try (Connection conn = conBD()) {
                    if (Double.parseDouble(nota) >=5) {
                    ps = conn.prepareStatement("INSERT INTO aprobados(id_alumno,nota) VALUES (?,?)");
                    ps.setString(1, id);
                    ps.setString(2, nota);
                    ps.executeUpdate();
                    System.out.println("notas agregadas");
                    }
                    
                    if(Double.parseDouble(nota) >=9) {
                        System.out.println("id = " + id);
                        System.out.println("notas = " + nota);
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
