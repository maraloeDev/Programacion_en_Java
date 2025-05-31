/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problema2Rec;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author Eduardo
 */
public class Problena2Rec {
    
    static Stack<Integer> enteros = new Stack<>();
    static Stack<Integer> aux = new Stack<>();
    
    public static void main(String[] args) {
        //Agrego los numeros a la pila
        enteros.push(7);
        enteros.push(2);
        enteros.push(5);
        enteros.push(2);
        enteros.push(6);
        
        //Localizo el numero mas pequeño
        int elementoPequeno = Collections.min(enteros);
        
        //Mientras la pila no este vacia, se van sacando todos los elementos
        
        //Si alguno de ellos es distinto que el 2, se va añadiendo el elemento a la pila aux
        while(!enteros.isEmpty()) {
            int elemento = enteros.pop();
            
            if(elemento!=elementoPequeno) {
                aux.push(elemento);
            }
            
        }
            System.out.println(aux);
    }
    
}
