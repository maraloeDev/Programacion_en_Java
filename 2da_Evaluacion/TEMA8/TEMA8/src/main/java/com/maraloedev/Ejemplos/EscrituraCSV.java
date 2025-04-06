package com.maraloedev.Ejemplos;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraCSV {

    public static void main(String[] args) {
        String archivoCSV = "src\\main\\java\\com\\maraloedev\\Ejemplos\\FicherosCSV\\alumnos.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(archivoCSV))) {
            // Escribir la cabecera
            String[] header = {"ID", "Nombre", "Edad", "Ciudad"};
            writer.writeNext(header);

            // Escribir datos
            String[] dato1 = {"1", "Juan Pérez", "30", "Madrid"};
            String[] dato2 = {"2", "María López", "25", "Barcelona"};
            String[] dato3 = {"3", "Carlos Sánchez", "35", "Sevilla"};

            writer.writeNext(dato1);
            writer.writeNext(dato2);
            writer.writeNext(dato3);

            System.out.println("Archivo CSV creado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
