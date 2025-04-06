import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio01_LeerNombres {

    /**
     * Ejercicio 1: Leer un archivo CSV y almacenarlo en una lista de objetos
     * Objetivo: Leer un archivo CSV con información de empleados (nombre, edad, puesto) y almacenarlo en una lista de objetos Empleado.
     *
     * Instrucciones:
     *
     * Crea una clase Empleado con atributos nombre, edad, y puesto.
     *
     * Lee un archivo CSV con la siguiente estructura:

     * Juan,30,Gerente
     * Ana,25,Asistente
     * Luis,40,Director
     * Almacena cada línea como un objeto Empleado en una lista (ArrayList).
     *
     * Imprime la lista de empleados.
     */

    static File f = new File("empleados.csv");
    static ArrayList<Ejercicio01_Empleado> listaEmpleados = new ArrayList<>();

    public static void escrituraCSV(File f) {

        try(CSVWriter csvWriter = new CSVWriter(new FileWriter(f))) {

            String[] cabecera = {"nombre", "edad", "puesto"};
            csvWriter.writeNext(cabecera);

            listaEmpleados.add(new Ejercicio01_Empleado("Carlos", "45", "Ingeniero"));
            listaEmpleados.add(new Ejercicio01_Empleado("Juan", "24", "Matematico"));
            listaEmpleados.add(new Ejercicio01_Empleado("Maria", "18", "Streamer"));

            // Agregas los empleados, luego lo recorres, y vas añadiendo los empleados al CSV
            for (Ejercicio01_Empleado empleado1 : listaEmpleados) {
                csvWriter.writeNext(empleado1.toCSV());
            }
                System.out.println("Datos escritos correctamente");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lecturaCSV(File f) {

        try(CSVReader csvReader = new CSVReader(new FileReader(f))) {


            String[] linea = null;

            while ((linea=csvReader.readNext())!=null) {
                System.out.println(Arrays.toString(linea));
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        escrituraCSV(f);
        lecturaCSV(f);
    }
}
