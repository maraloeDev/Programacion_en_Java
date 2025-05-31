/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.BufferedWriter;
import java.io.File;
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

/**
 *
 * @author Eduardo
 */
public class Problema2 {

    static Scanner scanner = new Scanner(System.in);

    static String url = "jdbc:mysql://localhost:3306/junio2023";
    static String user = "root";
    static String password = "";
    static PreparedStatement ps;
    static ResultSet rs;

    static char operacion;

    public static void main(String[] args) {
        System.out.print("Introduce una operacion [A-B]: ");
        operacion = scanner.next().charAt(0);
        tipoOperacion(operacion);
    }

    /**
     * Compruebo si la operacion es la indicada es la correcta, si no es asi,
     * se le indica al usuario no es correcta la operacion, si la operacion es
     * correcta, si es A, llama al metodo altaUsuario, si es B, llama al metodo
     * bajaUsuario.
     */
    private static void tipoOperacion(char operacion) {
        try (Connection conn = conBD()) {
            ps = conn.prepareStatement("SELECT * FROM movimientos WHERE operación = ?");
            ps.setString(1, String.valueOf(operacion));
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("La operacion no esta contemplada");
            }

            switch (operacion) {
                case 'A' ->
                    altaUsuario();
                case 'B' ->
                    bajaUsuario();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Problema2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Este metodo pide al usuario que introduzca un CIF_cliente y un nombre, lo
     * almaceno en un objeto cliente, y compruebo si el CIF_cliente esta en la
     * BD, si es asi, almaceno una incidencia, si no, inserto el nuevo cliente
     * en la BD.
     */
    private static void altaUsuario() {
        try (Connection con = conBD()) {
            System.out.print("Introduce un CIF_cliente: ");
            scanner.nextLine();
            String CIF_cliente = scanner.nextLine();

            System.out.print("Introduce un nombre_cliente: ");
            scanner.nextLine();
            String nombre_cliente = scanner.nextLine();
            Cliente c = new Cliente(CIF_cliente, nombre_cliente);

            ps = con.prepareStatement("SELECT * FROM clientes WHERE CIF_cliente = ?");
            ps.setString(1, CIF_cliente);
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Incidencia guardada");
                escribirIncidencia(operacion, CIF_cliente);
            } else {
                ps = con.prepareStatement("INSERT INTO clientes(CIF_cliente, nombre_cliente) VALUES(?,?)");
                System.out.println("Cliente agregado");
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Problema2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Pido al cliente el CIF_cliente, compruebo que no este en la BD, si es asi
     * se registra una incidencia, si es asi, se elimina el cliente depende del CIF.
     */
    private static void bajaUsuario() {
        try (Connection con = conBD()) {
            System.out.print("Introduce un CIF_cliente: ");
            scanner.nextLine();
            String CIF_cliente = scanner.nextLine();

            ps = con.prepareStatement("SELECT * FROM clientes WHERE CIF_cliente = ?");
            ps.setString(1, CIF_cliente);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Incidencia guardada");
                escribirIncidencia(operacion, CIF_cliente);
            } else {
                ps = con.prepareStatement("DELETE FROM clientes WHERE CIF_cliente = ?");
                ps.setString(1, CIF_cliente);
                System.out.println("Cliente eliminado");
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Problema2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void escribirIncidencia(char operacion, String CIF_cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("incidencias.txt"),true))) {
            bw.write("Fecha/Hora - Operacion - CIF");
            bw.newLine();
            bw.write(LocalDate.now().toString() + "-" + operacion + "-" + CIF_cliente);

        } catch (IOException ex) {
            Logger.getLogger(Problema2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static Connection conBD() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
