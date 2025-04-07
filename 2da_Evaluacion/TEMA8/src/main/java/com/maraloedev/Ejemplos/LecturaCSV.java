package com.maraloedev.Ejemplos;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LecturaCSV {
    public static void main(String[] args) {
        String archivoCSV = "datos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(archivoCSV))) {
            String[] fila;
            while ((fila = reader.readNext()) != null) {
                System.out.println(String.join(" | ", fila));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException ex) {
            Logger.getLogger(LecturaCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
