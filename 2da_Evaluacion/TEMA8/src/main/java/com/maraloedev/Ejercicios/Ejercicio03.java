package com.maraloedev.Ejercicios;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio03 {

    static File f1 = new File("src\\main\\java\\com\\maraloedev\\Ejercicios\\Ficheros\\Datos1.txt");
    static File f2 = new File("src\\main\\java\\com\\maraloedev\\Ejercicios\\Ficheros\\Datos2.txt");
    static File archivoDiferencias = new File("Dif.txt");

    public static void main(String[] args) {
        System.out.println("---------- ARCHIVO 1 ----------");
        lecturaCSV(f1);

        System.out.println("---------- ARCHIVO 2 ----------");
        lecturaCSV(f2);
        comparacionCSV(f1, f2);

    }

    private static void lecturaCSV(File f) {
        try (CSVReader csvr = new CSVReader(new FileReader(f))) {
            String[] linea1;

            while ((linea1 = csvr.readNext()) != null) {
                System.out.println(Arrays.toString(linea1));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio03.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | CsvValidationException ex) {
            Logger.getLogger(Ejercicio03.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   private static void comparacionCSV(File f1, File f2) {
    int diferencias = 0;
    int contadorLineas = 1;

    try (
        CSVReader cSVReader1 = new CSVReader(new FileReader(f1));
        CSVReader cSVReader2 = new CSVReader(new FileReader(f2));
        CSVWriter cSVWriter = new CSVWriter(new FileWriter(archivoDiferencias))
    ) {
        String[] linea1 = cSVReader1.readNext();
        String[] linea2 = cSVReader2.readNext();
        
        while (linea1 != null || linea2 != null) {
            if (!Arrays.equals(linea1, linea2)) {
                diferencias++;

                cSVWriter.writeNext(new String[]{
                    "Diferencia en línea " + contadorLineas,
                    "Archivo 1: " + (linea1 != null ? Arrays.toString(linea1) : "Línea vacía o nula"),
                    "Archivo 2: " + (linea2 != null ? Arrays.toString(linea2) : "Línea vacía o nula")
                });
            }

            contadorLineas++;
            linea1 = cSVReader1.readNext();
            linea2 = cSVReader2.readNext();
        }

        System.out.println("Total de diferencias encontradas: " + diferencias);

    } catch (FileNotFoundException ex) {
        Logger.getLogger(Ejercicio03.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | CsvValidationException ex) {
        Logger.getLogger(Ejercicio03.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
