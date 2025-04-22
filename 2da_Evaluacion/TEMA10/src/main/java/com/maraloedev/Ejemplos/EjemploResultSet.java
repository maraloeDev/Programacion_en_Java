package com.maraloedev.Ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author macarena
 *
 * Ejemplo de uso de un ResultSet para además de rcuperar datos, actualizarlos.
 * Para ello se utilizará la base de datos relacional MySQL llamada 'gf' que
 * consta de una única tabla 'alumnos' con 4 columnas (idalumno, nombre,
 * apellidos y nota). La conexión a la bd se hará utilizando el usuario root sin
 * contraseña.
 *
 * OPERATIVA: Las operaciones se realizarán seleccionandolas a través de un
 * JOptionPane con un combo con las distintas opciones. Esta ventana aparece
 * continuamente para realizar las operaciones progresivamente y ver los
 * resultados. Éstos se muestran en la consola. La inserción se hace un alumno
 * concreto dando los datos en código para simplificar el ejemplo.
 * 
 * NOTA: Observa como la conexión permanece abierta mientras se trabaja con la BD 
 *
 */
public class EjemploResultSet {

    private ResultSet resulSet;
    private Connection con;

    public static void main(String[] args) {
        EjemploResultSet ej = new EjemploResultSet();

        //opciones a mostrar en el JOptionPane
        Object[] operaciones = {"Recuperar alumnos", "Insertar alumno", "Modificar nota", "Eliminar alumno"};

        //cargamos el ResultSet
        ej.abrirConexion();
        ej.recuperarDatos();

        Object operacion = JOptionPane.showInputDialog(null, "Operación a realizar: ", "Ejemplo uso ResultSet", JOptionPane.PLAIN_MESSAGE, null, operaciones, operaciones[0]);

        while (operacion != null) { //mientras no pulse el boton Cancelar
            switch (String.valueOf(operacion)) {
                case "Recuperar alumnos" ->
                    ej.mostrarAlumnos();
                case "Insertar alumno" ->
                    ej.insertarAlumno();
                case "Modificar nota" ->
                    ej.modificarNota();
                case "Eliminar alumno" ->
                    ej.eliminarAlumno();
            }
            operacion = String.valueOf(JOptionPane.showInputDialog(null, "Operación a realizar: ", "Ejemplo uso ResultSet", JOptionPane.PLAIN_MESSAGE, null, operaciones, operaciones[0]));
        }

        ej.cerrarConexion(); 

    }

    //Creamos el ResultSet actualizable y desplazable.
    private void recuperarDatos() {
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resulSet = st.executeQuery("SELECT * FROM alumnos");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Muestra todos los datos de los alumnos
    private void mostrarAlumnos() {
        try {
            resulSet.first();
            do {
                System.out.println(resulSet.getInt(1) + " - " + resulSet.getString(2) + " - " + resulSet.getString(3)
                        + " : " + resulSet.getDouble(4));
            } while (resulSet.next());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    //Modifica la nota de un alumno buscándole por ID
    public void modificarNota() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID alumno: "));
        double nota = Double.parseDouble(JOptionPane.showInputDialog("Nueva nota: "));
        modificarNota(id, nota);
    }

    private void modificarNota(int pk, double nota) {
        int pos = buscarAlumno(pk);
        if (pos > -1) {
            System.out.println("Posicion: " + pos);
            try {
                resulSet.absolute(pos);
                resulSet.updateDouble(4, nota);
                resulSet.updateRow();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Alumno inexistente");
        }
    }

    //Busca en el ResultSet un alumno por ID
    private int buscarAlumno(int pk) {
        try {
            resulSet.first();
            boolean encontrado = false;
            do {
                if (resulSet.getInt(1) == pk) {
                    return resulSet.getRow();
                }
            } while (resulSet.next() && !encontrado);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    //Inserta una fila nueva en el ResultSet correspondiente a un alumno
    private void insertarAlumno() {
        try {
            resulSet.moveToInsertRow();
            resulSet.updateString(2, "Nuevo alumno");
            resulSet.updateString(3, "Nuevo alumno");
            resulSet.updateDouble(4, 10.0);
            resulSet.insertRow();
            resulSet.moveToCurrentRow();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    //Elimina un alumno buscándole por ID
    public void eliminarAlumno() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID alumno: "));
        eliminarAlumno(id);
    }

    private void eliminarAlumno(int pk) {
        int pos = buscarAlumno(pk);
        if (pos > -1) {
            System.out.println("Posicion: " + pos);
            try {
                resulSet.absolute(pos);
                resulSet.deleteRow();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Alumno inexisente");
        }
    }

    private void abrirConexion() {
        try {            
            String url = "jdbc:mysql://localhost:3306/gf";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void cerrarConexion() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
