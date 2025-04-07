package com.maraloedev.EjerciciosSergio;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio01_SergioDiario {

    /**
     * Programa de Diario en Java
     *
     * Este programa permite al usuario escribir entradas en un diario. Cada vez
     * que el usuario ejecuta el programa, puede agregar una nueva entrada, la
     * cual se añadirá al final de un archivo llamado "diario.txt".
     *
     * Luego, el programa leerá y mostrará todas las entradas guardadas en el
     * archivo.
     */
    static Scanner scanner = new Scanner(System.in);
    static File f = new File("src\\main\\java\\com\\maraloedev\\Ejercicios\\Ficheros\\diario.txt");
    static String texto = "";
    static ArrayList<String> entradasGuardadas = new ArrayList<>();
    

    public static void main(String[] args) {
        archivoExistente(f);
        
        int opt;
        
        do {
        System.out.println("Selecciona una opcion"
                + "1. Escritura"
                + "2. Lectura: ");
            opt = scanner.nextInt();
        switch(opt) {
            case 1 -> escritura();
            case 2 -> lectura();
        }
        } while (opt == 1 || opt == 2);   
    }

    public static void archivoExistente(File f) {

        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Ejercicio01_SergioDiario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void escritura() {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(f, true));

            System.out.print("Agregar una entrada: ");
            scanner.nextLine();
            texto = scanner.nextLine();
            bw.write(texto + " ");
            entradasGuardadas.add(texto);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio01_SergioDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void lectura() {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            String linea = null;
            try {
                while((linea=br.readLine())!=null) {
                    System.out.println(linea);
                }
                
                System.out.println("Las ultimas entradas que has escrito son " + entradasGuardadas.toString());
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Ejercicio01_SergioDiario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio01_SergioDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
