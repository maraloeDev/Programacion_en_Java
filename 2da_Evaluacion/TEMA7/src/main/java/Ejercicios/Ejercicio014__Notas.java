package Ejercicios;

import Ejercicios.Clases.Notas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio014__Notas {

    static HashMap<Integer, Notas> evaluaciones = new HashMap<>();
    static ArrayList<String> apellidosSort = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int contador = 1;
        double nota1;
        double nota2;
        double nota3;
        double notaMedia;

        while (contador <= 3) {

            System.out.print("Indique nombre: ");
            String nombre = scanner.nextLine();
            scanner.nextLine();

            System.out.print("Indique apellidos: ");
            String apellidos = scanner.nextLine();

            apellidosSort.add(apellidos);
            System.out.print("Introduce la primera nota");
            nota1 = scanner.nextDouble();

            System.out.print("Introduce la segunda nota");
            nota2 = scanner.nextDouble();

            System.out.print("Introduce la tercera nota");
            nota3 = scanner.nextDouble();
            evaluaciones.put(contador, new Notas(nota1, nota2, nota3));
            notaMedia = (nota1 + nota2 + nota3) / 3;
            System.out.println("La nota media de la " + contador
                    + " evaluacion es de " + notaMedia);
            contador++;
        }

        Collections.sort(apellidosSort);
        for (String ordenacion : apellidosSort) {
            System.out.println(ordenacion);
        }
    }
}
