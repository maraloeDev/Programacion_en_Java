package com.maraloedev.examenseptiembre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio03 {

    static HashMap<String, String> mapaDiccionario = new HashMap<>();
    static List<String> listaSignificados = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    private static void addPalabras(String palabra, String significado) {
        mapaDiccionario.put(palabra, significado);
        listaSignificados.add(significado);

        for (Map.Entry<String, String> palabraRepetida : mapaDiccionario.entrySet()) {
            if (!palabraRepetida.getKey().contains(palabra)) {

            }
        }

    }

    private static void getsignificado(String palabra) {

        System.out.println("Significado principal de " + palabra + " :");

        for (Map.Entry<String, String> signifcado : mapaDiccionario.entrySet()) {

            System.out.println("Significado principal de " + palabra + " es : " + signifcado.getValue());

        }
    }

    private static void getsignificados(String palabra) {

        System.out.println("Significado principal de " + palabra + " :");

        for (Map.Entry<String, String> signifcado : mapaDiccionario.entrySet()) {

            System.out.println("Significado principal de " + signifcado.getKey() + " es : " + signifcado.getValue());

        }
    }

    public static void main(String[] args) {
        System.out.print("Numero de palabras a introducir en el diccionario: ");
        int nPalabras = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= nPalabras; i++) {
            System.out.print("Palabra-" + i + ":");
            String palabra = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Significado [ENTER PARA TERMINAR]:");
            String significado = scanner.nextLine();

            if (significado.isEmpty()) {
                addPalabras(palabra, significado);
                System.out.println("Palabra almacenanda en el diccionario");

                getsignificados(palabra);
                getsignificado(palabra);
            } else {
                System.out.print("Significado [ENTER PARA TERMINAR]:");
            significado = scanner.nextLine();
            }
        }
    }
}
