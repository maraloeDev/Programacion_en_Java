/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import static Ejercicios.Ejercicio002_Datos.numerosEnteros;

/**
 *
 * @author Eduardo
 */
public class Ejercicio003_Datos2 {
    
    public static void main(String[] args) {
        
        int suma=0;
        int cuenta=0;
    
        for (int i = 0; i < numerosEnteros.length; i++) {
            if(i % 2 !=0 && numerosEnteros[i]%2==0) {
                System.out.println("El elemento par " + numerosEnteros[i] + 
                        " ocupa la posicion impar " + i);
                suma+=i;
                cuenta++;
            }
        }
        System.out.println("-------------------------------------------");
        System.out.println("La suma de los numeros que ocupan la posicion"
                + "impar es " + suma);
        System.out.println("La cuenta de los numeros que ocupan la posicion"
                + "impar es " + cuenta);
    }
}
