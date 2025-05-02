package App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PROG_PRACTICA_7_EDUARDO_MARTINSONSECA {

    static ArrayList<String> listaPalabras = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String palabraOculta;
    static String palabraSeleccionada;
    static char ultimaLetra;
    static int longitud;
    static int fallos;
    static ArrayList<String> letrasFalladas = new ArrayList<>();
    static int partidasGanadas = 0;
    static int partidasPerdidas = 0;
    static boolean partidaIniciada = true;

    public static void main(String[] args) {

        /**
         * Mientras que la partida este iniciada, llamar al metodo de
         * anadirPalabras y inicioPartida, una vez acabada la partida pregunto
         * si quieres jugar de nuevo, y si la respuesta es diferente de s, se
         * muestran las partidas ganadas y perdidas, y "rompo" el if para cortar
         * la ejecucion (Lineas 30-39).
         */
        while (partidaIniciada) {
            anadirPalabras();
            inicioPartida();

            System.out.println("¿Quieres jugar otra partida? (s/n)");
            String respuesta = scanner.next().toLowerCase();
            if (!respuesta.equals("s")) {
                System.out.println("Partidas ganadas: " + partidasGanadas);
                System.out.println("Partidas perdidas: " + partidasPerdidas);
                break;
            }
        }
    }

    /**
     * En este metodo, limpio la lista, añado las palabras a la lista, las
     * desordeno, recojo la primera palabra de la lista despues recojo la ultima
     * letra de la palabra seleccionada, almaceno la longitud de la palabra
     * seleccionada, inicializo los fallos a 0, y limpio el array de las letras
     * falladas (Lineas 58-72)
     *
     * Recorro con un bucle for la longitud de la palabra seleccionada y si el
     * caracter de la palabra seleccionada concuerda con la ultima letra, le
     * añadades a la variable palabraSeleccionada el caracter de la palabra y si
     * no, me muestras una _ (Lineas 74-78)
     *
     * Despues muestro la palabraOculta (Lineas 81-84)
     */
    private static void anadirPalabras() {
        listaPalabras.clear();
        listaPalabras.add("MARIPOSA");
        listaPalabras.add("ARBOL");
        listaPalabras.add("ROBLE");
        listaPalabras.add("PYTHON");

        Collections.shuffle(listaPalabras);

        palabraSeleccionada = listaPalabras.get(0);
        ultimaLetra = palabraSeleccionada.charAt(palabraSeleccionada.length() - 1);
        longitud = palabraSeleccionada.length();
        palabraOculta = "";
        fallos = 0;
        letrasFalladas.clear();

        for (int i = 0; i < longitud; i++) {
            if (palabraSeleccionada.charAt(i) == ultimaLetra) {
                palabraOculta += palabraSeleccionada.charAt(i) + " ";
            } else {
                palabraOculta += "_ ";
            }
        }
        System.out.println("----- JUEGO DEL AHORCADO ----- ");
        System.out.println("Palabra a adivinar:");
        System.out.print(palabraOculta);
        System.out.println("");
    }

    /**
     * En este metodo, mientras los fallos sean menores que 8 y la palabra
     * oculta contiene un _ , invicocas al metodo comprobaciones (Lineas 99-101)
     *
     * Compruebo si la palabra oculta no contiene una _ y si es asi, muestro un
     * mensaje de felicitación al usuario, mostrandole la palabra adivinada e
     * incrementara las partidas ganadas a 1,de lo contrario, mostrara un
     * mensaje de "GAME OVER", y mostrando la palabra que era, e incrementando
     * las partida perdida (Lineas 102-109).
     */
    private static void inicioPartida() {
        while (fallos < 8 && palabraOculta.contains("_")) {
            comprobaciones();
        }

        if (!palabraOculta.contains("_")) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSeleccionada);
            partidasGanadas++;
        } else {
            System.out.println("HAS PERDIDO");
            System.out.println("La palabra era: " + palabraSeleccionada);
            partidasPerdidas++;
        }
    }

    /**
     * En este metodo, pido al usuario la letra, y compruebo si la longitud es
     * mayor que 1 o si la letra contiene numeros del 1 al 9, si es asi, muestro
     * un mensaje de error, y lo vuelvo a perdir (Lineas 133-141)
     *
     * Compruebo si la palabra seleccionada contiene alguna letra introducida
     * por el usuario, si es asi, modifico el string de la palabra oculta,
     * recorriendo la longitud de la palabra seleccionada y si el caracter de i
     * concuerda con la letra que ha introducido el usuario, establezco a la
     * nueva palabra oculta que es la palabra que ha introducido, * 2, (Pongo el
     * X 2 debido a que hay espacios), y actualizo la palabra oculta por la
     * nueva agregando la letra que a introducido el usuario (Lineas 143-151).
     *
     * Si el array de las letras falladas contiene la letra que a introducido el
     * usuario, incrementa en 1 el fallo y añades a la lista la letra (Lineas
     * 154-156).
     *
     * Una vez acabado, muestras un "resumen" con la palabra actual, las letras
     * que has fallado, y el numero de fallos, e invocas al metodo de
     * mostrarAhorcado (Lineas 160-163).
     */
    private static void comprobaciones() {
        String letra;
        do {
            System.out.print("Introduce una letra: ");
            letra = scanner.next().toUpperCase();

            if (letra.length() > 1 || !letra.matches("[A-Z]")) {
                System.err.println("Tiene que poner solo 1 caracter válido (sin números ni símbolos).");
            }
        } while (letra.length() > 1 || !letra.matches("[A-Z]"));

        if (palabraSeleccionada.contains(letra)) {
            StringBuilder nuevaPalabraOculta = new StringBuilder(palabraOculta);

            for (int i = 0; i < palabraSeleccionada.length(); i++) {
                if (palabraSeleccionada.charAt(i) == letra.charAt(0)) {
                    nuevaPalabraOculta.setCharAt(i * 2, letra.charAt(0));
                }
            }
            palabraOculta = nuevaPalabraOculta.toString();
        } else {
            if (!letrasFalladas.contains(letra)) {
                fallos++;
                letrasFalladas.add(letra);
            }
        }

        System.out.println("Palabra actual: " + palabraOculta);
        System.out.println("Letras falladas: " + letrasFalladas);
        System.out.println("Fallos restantes: " + (8 - fallos));
        mostrarAhorcado();
    }

    /**
     * En este metodo, hago el dibujo del ahorcado
     */
    private static void mostrarAhorcado() {
        String[] ahorcado = {
            "  \n  \n  \n  \n  ",
            "  ──\n  \n  \n  \n  ",
            "  ──\n  |\n  \n  \n  ",
            "  ──\n  |\n  O\n  \n  ",
            "  ──\n  |\n  O\n  |\n  ",
            "  ──\n  |\n  O\n /|\n  ",
            "  ──\n  |\n  O\n /|\\\n  ",
            "  ──\n  |\n  O\n /|\\\n /  ",
            "  ──\n  |\n  O\n /|\\\n / \\ "
        };

        System.out.println(ahorcado[fallos]);
    }
}
