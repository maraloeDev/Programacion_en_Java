/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problema3Rec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class Problema3 {

    static Map<String, ArrayList<String>> mapaSignificados = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("N. de palabras a introducir en el diccionario: ");
        int nPalabras = scanner.nextInt();

        for (int i = 1; i <= nPalabras; i++) {

            System.out.print("Palabra-" + i + ":");
            scanner.nextLine();
            String palabra = scanner.nextLine();
                System.out.println("Significado [ENTER para terminar]:");

            String significado = scanner.nextLine();
            
            while(!significado.isEmpty()) {
                System.out.println("Significado [ENTER para terminar]:");
                significado= scanner.nextLine();
                addPalabra(palabra, significado);
            }
                getSignificado(palabra);
                getSignificados(palabra);

        }
    }

    private static void addPalabra(String palabra, String significado) {
        if (!mapaSignificados.containsKey(palabra)) {
            mapaSignificados.put(palabra, new ArrayList<>());
        }
        ArrayList<String> listaSignificados = mapaSignificados.get(palabra);

        if (!listaSignificados.contains(significado)) {
            listaSignificados.add(significado);
        }
    }

    private static void getSignificado(String palabra) {
        mapaSignificados.containsKey(palabra);

        ArrayList<String> listaSignificados = mapaSignificados.get(palabra);
        System.out.println("Significado principal de: " + palabra + "\n\t" + listaSignificados.get(0));
    }

    private static void getSignificados(String palabra) {
        mapaSignificados.containsKey(palabra);

        ArrayList<String> listaSignificados = mapaSignificados.get(palabra);

            System.out.println("Significados de: " + palabra);
        for (String significados : listaSignificados) {
            
            System.out.println("\t" + significados);
        }
    }

}
