import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio04 {

    /**
     * Ejercicio 4: Leer un archivo CSV con datos de estudiantes y almacenarlo en un ArrayList
     * Objetivo: Leer un archivo CSV con nombres de estudiantes y sus calificaciones y almacenarlo en una lista de objetos Estudiante.
     *
     * Instrucciones:
     *
     * Crea una clase Estudiante con atributos nombre y calificacion.
     *
     * Lee un archivo CSV con la siguiente estructura:
     *
     * Maria,90
     * Pedro,85
     * Carlos,88
     * Almacena cada línea como un objeto Estudiante en un ArrayList.
     *
     * Imprime los datos de todos los estudiantes.
     */

    static File f = new File("Estudiante.csv");
    static ArrayList<Ejercicio04_Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<String[]> almacenaesEstudiantes = new ArrayList<>();


    public static void main(String[] args) {
        escrituraCSV(f);
        lecturaCSV(f);
    }

    public static void escrituraCSV(File f) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(f))) {

            String[] cabecera = {"Nombre", "Calificacion"};
            csvWriter.writeNext(cabecera);

            estudiantes.add(new Ejercicio04_Estudiante("Eduardo", 8));
            estudiantes.add(new Ejercicio04_Estudiante("Mario", 5));

            for(Ejercicio04_Estudiante estudiante : estudiantes) {
                csvWriter.writeNext(estudiante.toCSV());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lecturaCSV(File f) {

        try (CSVReader csvReader = new CSVReader(new FileReader(f))) {

            String[] linea = null;

            while ((linea = csvReader.readNext())!= null) {
                almacenaesEstudiantes.add(linea);
            }
            for(String[] estudiante1 : almacenaesEstudiantes) {
                System.out.println(Arrays.toString(estudiante1));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }
}
