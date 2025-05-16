package Ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Probema03Rec {

    public static void main(String[] args) {
        menu();
    }

    /**
     * El diccionario almacenará el/los significados de palabras. Cada palabra
     * es única y puede tener uno o varios significados, por lo que se utilizará
     * un ArrayList para almacenarlos.
     */
    static Map<String, ArrayList<String>> mapaDiccionario = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    private static void menu() {
        System.out.print("Nº palabras a introducir en el diccionario: ");
        int nPalabras = scanner.nextInt();
        System.out.println("----------------------------------------------------------------------------- ");

        for (int i = 1; i <= nPalabras; i++) {
            System.out.print("Palabra-" + i + ": ");
            scanner.nextLine();
            String palabra = scanner.nextLine();

            System.out.print("Significado [ENTER para terminar]: ");
            String significado = scanner.nextLine();

            while (!significado.isEmpty()) {
                addPalabra(palabra, significado);

                System.out.print("Significado [ENTER para terminar]: ");
                significado = scanner.nextLine();
            }

            System.out.println("----------------------------------------------------------------------------- \n"
                    + "Significado principal de " + palabra);
            getSignificado(palabra);

            System.out.println("----------------------------------------------------------------------------- \n"
                    + "Significados de " + palabra);
            getSignificados(palabra);

        }
    }

    /**
     * Método que almacena la palabra con el significado recibidos como
     * parámetros, si la palabra no existe en el diccionario.
     *
     * En el caso de que la palabra ya esté almacenada en el diccionario
     * entonces añade el nuevo significado a los ya existentes.
     */
    private static void addPalabra(String palabra, String significado) {
        /**
         * Si el mapa no contiene la palabra, me añades la palabra y un nuevo
         * significado al diccionario
         */
        if (!mapaDiccionario.containsKey(palabra)) {
            mapaDiccionario.put(palabra, new ArrayList<>());
        }

        // Recojo los significados de la palabra agregada
        ArrayList<String> listaSignificados = mapaDiccionario.get(palabra);

        // Si la lista no contiene el significado, lo agrega a la lista
        if (!listaSignificados.contains(significado)) {
            listaSignificados.add(significado);
        }
    }

    /**
     * Método que devuelve el PRIMER significado de la palabra recibida como
     * parámetro. En el caso de que la palabra no exista en el diccionario,
     * devolverá null.
     */
    private static void getSignificado(String palabra) {

        if (mapaDiccionario.containsKey(palabra)) {
            // Recojo los significados de la palabra agregada
            ArrayList<String> listaSignificados = mapaDiccionario.get(palabra);
            System.out.println(listaSignificados.get(0));
        } else {
            System.out.println("null");
        }
    }

    /**
     * * Método que devuelve el TODOS los significado de la palabra recibida
     * como parámetro. En el caso de que la palabra no exista en el diccionario,
     * devolverá null.
     */
    private static void getSignificados(String palabra) {
        if (mapaDiccionario.containsKey(palabra)) {
            // Recojo los significados de la palabra agregada
            ArrayList<String> listaSignificados = mapaDiccionario.get(palabra);
            for (String ddefiniciones : listaSignificados) {
                System.out.println(ddefiniciones);
            }
        } else {
            System.out.println("null");
        }
    }
}
