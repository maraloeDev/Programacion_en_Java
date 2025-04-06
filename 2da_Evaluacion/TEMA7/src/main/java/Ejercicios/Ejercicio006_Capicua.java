/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Random;

/**
 *
 * @author Eduardo
 */
public class Ejercicio006_Capicua {

    public static void main(String[] args) {

        Random random = new Random();
        int[] numeroCapicua = new int[10];

        String capicua = null;

        for (int i = 0; i < numeroCapicua.length; i++) {
            int nRandoms = random.nextInt(10, 20);
            numeroCapicua[i] = nRandoms;

            String original = String.valueOf(numeroCapicua[i]);
            StringBuilder reverseNumber = new StringBuilder(String.valueOf(numeroCapicua[i]));

            capicua = reverseNumber.reverse().toString();

            if (original.equals(capicua)) {
                System.out.println("El número " + numeroCapicua[i] + " es capicúa");
            } else {
                System.out.println("El número " + numeroCapicua[i] + " no es capicúa");
            }

        }

    }

}
