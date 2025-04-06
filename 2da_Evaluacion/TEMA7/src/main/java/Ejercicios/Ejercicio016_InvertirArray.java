package Ejercicios;

import java.util.Arrays;
import java.util.LinkedList;


public class Ejercicio016_InvertirArray {
    
    static int[] enteros = {1,2,3,4,5,6,7,8,9,10};
    static LinkedList<Integer> listaNumeros = new LinkedList<>();
    
    public static void main(String[] args) {
        System.out.println("Array original: " + Arrays.toString(enteros));
        
        //Añado los numeros del array a la pila
        for(Integer pila : enteros) {
            listaNumeros.push(pila);
        }
        
        int i = 0;
        
        //Mientras la pila no este vacia, los numeros de i, los vas sacando
        while(!listaNumeros.isEmpty()) {
            enteros[i] = listaNumeros.pop();
            i++;
        }
        System.out.println("Array invertido: " + Arrays.toString(enteros));
    }
    
}
