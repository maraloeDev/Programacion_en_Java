package Ejercicios;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Eduardo
 */
public class Ejercicio005_ListaAleatoria {

    static Random random = new Random();
    static Integer[] listaAleatoria = new Integer[10];
    static Set<Integer> numerosRepetidos = new HashSet<>();

    public static void main(String[] args) {
        for (int i = 0; i <= listaAleatoria.length; i++) {
            int nRandoms;
            do {
                nRandoms = random.nextInt(1, 10);
            } while (!numerosRepetidos.add(nRandoms));

            numerosRepetidos.add(listaAleatoria[i]);
            listaAleatoria[i] = nRandoms;
            
            System.out.print(listaAleatoria[i] + " ");
        }

    }
}
