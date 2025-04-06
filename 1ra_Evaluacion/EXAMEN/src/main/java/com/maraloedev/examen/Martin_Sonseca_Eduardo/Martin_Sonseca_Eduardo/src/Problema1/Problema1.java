package Problema1;

import java.util.Random;
import java.util.Scanner;

public class Problema1 {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int nIntentos = 1;
        int nAcertar = random.nextInt(1, 100);
        int numero = 0;
        boolean acierto = false;

        System.out.println("He pensado un numero entre 1 y 100. Tienes 5 intentos para adivinarlo.");
        while (acierto == false) {
            numero = scanner.nextInt();

            //Mensaje de felicitacion
            if (numero == nAcertar) {
                System.out.println("Felicidades, has acertado el numero");
                acierto = true;
                break;
            } else {

                if (numero > nAcertar) {
                    System.out.println("El numero es mayor. Sigue intentandolo");
                } else if (numero < nAcertar) {
                    System.out.println("El numero es menor. Sigue intentandolo");
                }
                System.out.print("Intento " + nIntentos + ": Cual es el numero: ");
                    nIntentos++;

            if (nIntentos == 5) {
                System.out.println(">>> Lo siento intentos agotados. numero secreto: " + nAcertar);
                break;

            }
            }
        }

    }

}
