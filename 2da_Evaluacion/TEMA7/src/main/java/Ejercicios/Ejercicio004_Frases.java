/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class Ejercicio004_Frases {

    static String[] frases = new String[5];
    static Scanner scanner = new Scanner(System.in);

    public static String imprimeFrases() {
        for (int i = 0; i < frases.length; i++) {
            System.out.print((i + 1) + " Introduce una frase ");
            String frase = scanner.nextLine();
            frases[i] = frase;
        }

        return "EL CONTENIDO DEL ARRAY ES\n" + Arrays.toString(frases);
    }

    public static String mayorFrase() {
        String fraseLarga = "";
        for (int i = 0; i < frases.length; i++) {

            if (frases.length > fraseLarga.length()) {
                fraseLarga = frases[i];
            }
        }
        return "La frase mas larga es " + fraseLarga;
    }

    public static String menorFrase() {
        
        //Recojo la primera frase
        String fraseCorta = frases[0];
        
        for (int i = 0; i < frases.length; i++) {
            
            if (frases[i].length() < fraseCorta.length()) {
                fraseCorta = frases[i];
            }
        }
        return "La frase mas corta es " + fraseCorta;
    }

    public static void main(String[] args) {
        System.out.println(imprimeFrases());
        System.out.println(mayorFrase());
        System.out.println(menorFrase());
    }
}
