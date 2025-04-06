/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.PilasYColas;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Eduardo
 */
public class EjemploPila {
    
    public static void main(String[] args) {
        
        String[] semana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        
        System.out.println("Array original: " + Arrays.toString(semana));
        
        LinkedList<String> pila = new LinkedList<>();
        for(String dia: semana) {
            pila.push(dia);
        }
        
        System.out.println("Estado inicial de la pila: " + pila);
        
        int i = 0;
        while(!pila.isEmpty()) {
            semana[i] = pila.pop();
            i++;
            
        }
        
        System.out.println("Array invertido: " + Arrays.toString(semana));
    }
    
}
