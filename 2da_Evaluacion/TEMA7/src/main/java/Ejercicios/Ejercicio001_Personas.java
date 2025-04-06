package Ejercicios;

import java.util.Scanner;

public class Ejercicio001_Personas {

    static Scanner scanner = new Scanner(System.in);
    static String[] personas = new String[5];

    // visualiza por pantalla los elementos del array, una en cada fila. 
    private static void imprimePersonas() {

        //Recorro el array y pido el nombre de las personas
        for (int i = 0; i < personas.length; i++) {
            System.out.print(i + " Introduce una persona: ");
            String persona = scanner.nextLine();
            personas[i] = persona;

        }
    }

    // Visualiza por pantalla los elementos del array 
    // que ocupan las posiciones pares. 
    // Cada elemento debe ir en una fila. 
    private static void pares() {

        for (int i = 0; i < personas.length; i++) {
            if ((i % 2) == 0) {
                System.out.println(i + " " + personas[i]);
            }

        }
    }

    public static void main(String[] args) {
        imprimePersonas();
        System.out.println("LOS ELEMENTOS PARES SON");
        pares();
    }
}
