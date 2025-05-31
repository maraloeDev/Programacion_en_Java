/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.martin_sonseca_eduardo.problema2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class Problema2 {

    static ArrayList<String> listaTareas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {

            System.out.println("Introduce la opcion: 1 - anadir tareas\n 2- mostrar tareas\n 3- Buscar tarea");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    anadirTarea();
                    break;
                case 2:
                    mostrarTareasPendientes();
                    break;
                case 3:
                    buscarTarea();
                    break;

                case 4:
                    System.exit(0);
                default:
                    System.out.println("Operacion no contemplada");
            }

        } while (opcion != 4);
    }

    private static void anadirTarea() {
        System.out.println("Introduce el nombre de la tarea: ");
        scanner.nextLine();
        String tarea = scanner.nextLine();
        listaTareas.add(tarea);
        System.out.println("Tarea agregada correcttamente");
    }

    private static void mostrarTareasPendientes() {

        if (listaTareas.isEmpty()) {
            System.out.println("La lista esta vacia");
        }
        for (String tareasP : listaTareas) {
            System.out.println(tareasP);
        }

    }

    private static void buscarTarea() {
        boolean encontrado = false;
        System.out.println("Introduce el nombre de la tarea a buscar: ");
        scanner.nextLine();
        String tarea_a_buscar = scanner.nextLine();

        for (String tareaBuscar : listaTareas) {
            if (tareaBuscar.equals(tarea_a_buscar)) {
                System.out.println("Tarea encontrada " + tareaBuscar);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Tarea no encontrada");
        }
    }

}
