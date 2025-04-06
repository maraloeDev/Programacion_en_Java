/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author Eduardo
 */
public class Ejercicio002_Datos {

    static int numerosEnteros[] = {1,2,3,4,5,6,7,8,9,10};

    // Imprime por pantalla 
    // los elementos que ocupan las posiciones pares
    public static void sumaPares() {
        int suma=0;
        for (int i = 0; i < numerosEnteros.length; i++) {
            if ((i % 2) == 0) {
                System.out.println("Los elementos que ocupan las posiciones"
                        + "pares son " + i);
                suma+=i;
            }
        }
        System.out.println("La suma de todos los numeros pares es de " + suma);
    }

    public static void main(String[] args) {
        sumaPares();
    }
}
