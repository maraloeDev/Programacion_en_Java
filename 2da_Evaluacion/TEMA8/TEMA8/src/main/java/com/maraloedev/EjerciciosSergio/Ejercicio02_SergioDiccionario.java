package com.maraloedev.EjerciciosSergio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio02_SergioDiccionario {

    /**
     * Programa de Diccionario en Java
     *
     * Este programa permite al usuario crear un diccionario personalizado en un
     * archivo de texto llamado "diccionario.txt". El usuario puede agregar
     * nuevas palabras con sus definiciones y buscar palabras dentro del
     * archivo.
     *
     * Funcionalidades: - Agregar palabras junto con sus definiciones. - Si una
     * palabra tiene varias definiciones, se almacenan todas. - Buscar palabras
     * y mostrar todas sus definiciones.
     *
     * Ejemplo de escritura: --------------------- P: Dime una palabra U: Gato
     * P: Dime la definición U: Animal que hace miau P: Definición guardada
     *
     * Ejemplo de lectura: ------------------- P: ¿Qué palabra quieres saber? U:
     * Gato P: Definiciones de "Gato": 1 - Cosa que levanta coches 2 - Animal
     * que hace miau
     *
     * Ejemplo de archivo: ------------------- palabra1 - definición1 palabra2 -
     * definición2
     */
    static Scanner scanner = new Scanner(System.in);
    static File f = new File("src\\main\\java\\com\\maraloedev\\Ejercicios\\Ficheros\\diccionario.txt");
    static Map<String, ArrayList<String>> diccionario = new HashMap<>();
    static ArrayList<String> defs = new ArrayList<>();
    BufferedReader br;

    public static void main(String[] args) {
        archivoExistente(f);
        funcionalidades();
    }

    private static void funcionalidades() {
        int opcion = 0;
        do {
            System.out.print("""
                           Funcionalidades:
                            1. Agregar palabras junto con sus definiciones.
                            2. Buscar palabras y mostrar todas sus definiciones.
                            3. Mostrar todas sus definiciones
                             4. Salir
                                Indique una opcion: """);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarPalabras();
                    break;

                case 2:
                    busquedaPalabras();
                    break;

                case 3:
                    mostrarPalabras();
                    break;

                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opcion no contemplada");

            }

        } while (opcion >= 1 || opcion <= 3);
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

    private static void agregarPalabras() {
        System.out.print("Dime una palabra: ");
        scanner.nextLine();
        String palabra = scanner.nextLine();

        System.out.print("Dime la definicion: ");
        String definicion = scanner.nextLine();
        ArrayList<String> definiciones = diccionario.getOrDefault(palabra, new ArrayList<>());
        definiciones.add(definicion);

        diccionario.put(palabra, definiciones);
        System.out.println("Definición guardada");
        escribirArchivo(diccionario);

    }

    private static void busquedaPalabras() {
        System.out.println("¿Qué palabra quieres saber? ");
        scanner.nextLine();
        String palabraBuscada = scanner.nextLine();

        boolean encontrado = false;
        int contador = 1;

        for (Map.Entry<String, ArrayList<String>> busquedaPalabras : diccionario.entrySet()) {
            String palabra = busquedaPalabras.getKey();
            ArrayList<String> definiciones = busquedaPalabras.getValue();

            if (palabraBuscada.equalsIgnoreCase(palabra)) {
                System.out.println("Definiciones de " + palabraBuscada + ":");

                for (String definicion : definiciones) {
                    System.out.println(contador++ + "- " + definicion);
                }

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("La palabra no se ha encontrado.");
        }
    }

    private static void mostrarPalabras() {

        if (diccionario.isEmpty()) {
            System.out.println("El diccionario esta vacio");
        } else {
            int cont = 1;
            for (Map.Entry<String, ArrayList<String>> diccionario : diccionario.entrySet()) {

                System.out.println("Palabra: " + diccionario.getKey());

                for (String definicion : diccionario.getValue()) {
                    System.out.println(cont++ + "- " + definicion);
                }

            }
            leerArchivo(diccionario);
        }
    }

    private static void escribirArchivo(Map<String, ArrayList<String>> dic) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {

            int cont = 1;
            for (Map.Entry<String, ArrayList<String>> diccionario : diccionario.entrySet()) {

                bw.write("Palabra: " + diccionario.getKey() + "\n");

                for (String definicion : diccionario.getValue()) {
                    bw.write("\t" + cont++ + "- " + definicion);
                }
                bw.write("\n");

            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio02_SergioDiccionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void leerArchivo(Map<String, ArrayList<String>> dic) {

        try (BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(f)))) {

            String linea = null;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio02_SergioDiccionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio02_SergioDiccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
