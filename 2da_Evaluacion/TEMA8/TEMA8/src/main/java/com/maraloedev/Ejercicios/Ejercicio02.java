package com.maraloedev.Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio02 {

    static File f1 = new File("src\\main\\java\\com\\maraloedev\\Ejercicios\\Ficheros\\Datos1.txt");
    static File f2 = new File("src\\main\\java\\com\\maraloedev\\Ejercicios\\Ficheros\\Datos2.txt");

    public static void main(String[] args) {
        lecturaFicheros(f1);
        lecturaFicheros(f2);
        System.out.println(comparacionFicheros(f1, f2));
    }

    public static void lecturaFicheros(File f) {

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            String linea = null;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio02.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String comparacionFicheros(File f1, File f2) {
        return  f1.equals(f2) ? "Los ficheros son iguales" : "Los archivos no son iguales";

    }
}
