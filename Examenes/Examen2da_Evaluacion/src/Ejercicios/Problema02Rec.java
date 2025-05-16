package Ejercicios;

import java.util.Collections;
import java.util.Stack;


public class Problema02Rec {
    
    static Stack<Integer> pilaEnteros = new Stack<>();
    static Stack<Integer> pilaAux = new Stack<>();
    
    public static void main(String[] args) {
        
        //Agrego los numeros
        pilaEnteros.push(7);
        pilaEnteros.push(2);
        pilaEnteros.push(5);
        pilaEnteros.push(2);
        pilaEnteros.push(6);
        
        //Localizo el numero mas pequeño de la pila
        int menorNumero = Collections.min(pilaEnteros);
        
        /**
         * Recorro la pila mientras no este vacia, "elimino" el primer valor de
         * la pila y, si el elemento que saco es diferente que el numero mas pe
         * queño de la pila, se añade el elemento que cumpla la condicion a una
         * pila auxiliar.
         */
        while(!pilaEnteros.isEmpty()) {
            int elemento = pilaEnteros.pop();
            if(elemento!=menorNumero) {
                pilaAux.push(elemento);
            }
        }
        
        System.out.println(pilaAux);
    }
}
