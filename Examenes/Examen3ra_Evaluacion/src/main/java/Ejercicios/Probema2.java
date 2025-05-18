package Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Probema2 {

    static String url = "jdbc:mysql://localhost:3306/junio2023";
    static String user = "root";
    static String password = "";
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Pido la operacion a realizar por el usuario
        System.out.println("Seleccione una operacion [A-B]: ");
        char operacion = scanner.next().toUpperCase().charAt(0);
        analizoMovimientos(operacion);
    }

    private static void analizoMovimientos(char operacion) {
        try (Connection conn = conBD()) {
            ps = conn.prepareStatement("SELECT * FROM movimientos WHERE operación = ?");
            ps.setString(1, String.valueOf(operacion));
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Operacion no contemplada");
                return;
            }

            operacionSececcionada(operacion);

        } catch (SQLException ex) {
            Logger.getLogger(Probema2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void operacionSececcionada(char operacion) {

        switch (operacion) {
            case 'A':
                try (Connection conn = conBD()) {

                System.out.println("Introduce un CIF_cliente: ");
                scanner.nextLine();
                String cif_Cliente = scanner.nextLine();

                System.out.println("Introduce un nombre_cliente: ");
                String nombre_cliente = scanner.nextLine();

                Cliente c = new Cliente(cif_Cliente, nombre_cliente);

                ps = conn.prepareStatement("SELECT * FROM clientes WHERE CIF_cliente = ?");
                ps.setString(1, c.getCif_cliente());
                rs = ps.executeQuery();

                if ((rs.next())) {
                    incidencias(operacion, cif_Cliente);
                    System.out.println("Incidencia registrada");
                } else {
                    ps = conn.prepareStatement("INSERT INTO "
                            + "clientes (CIF_cliente, nombre_cliente)"
                            + " VALUES(?,?)");
                    ps.executeUpdate();
                    System.out.println("Cliente agregado");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Probema2.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case 'B':
                
                try (Connection conn = conBD()) {

                System.out.println("Introduce un CIF_cliente: ");
                scanner.nextLine();
                String cif_Cliente = scanner.nextLine();

                ps = conn.prepareStatement("SELECT * FROM clientes WHERE CIF_cliente = ?");
                ps.setString(1, cif_Cliente);
                rs = ps.executeQuery();

                if ((!rs.next())) {
                    incidencias(operacion, cif_Cliente);
                    System.out.println("Incidencia registrada, el cliente no existe en la BD");
                } else {
                    ps = conn.prepareStatement("DELETE FROM clientes WHERE CIF_cliente = ?");
                    ps.setString(1, cif_Cliente);
                    ps.executeUpdate();
                    System.out.println("Cliente eliminado");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Probema2.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;
            default:
                System.out.println("Operacion no contemplada");
        }

    }

    private static void incidencias(char operacion, String cif) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("incidencias.txt"), true))) {

            bw.write("Fecha/Hora - operacion - CIF");
            bw.newLine();
            bw.write(LocalDate.now().toString() + " - " + operacion + " - " + cif);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Probema2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Probema2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection conBD() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
