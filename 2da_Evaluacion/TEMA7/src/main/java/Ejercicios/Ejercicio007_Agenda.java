package Ejercicios;

import Ejercicios.Clases.Contacto;
import java.util.Scanner;

public class Ejercicio007_Agenda {
    static Contacto[] agenda = new Contacto[100];
    static Scanner scanner = new Scanner(System.in);
    static int cantidadContactos = 0; 

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String opcion;
        do {
            System.out.println("""
                    Introduce una opcion:
                    1. Añadir contacto
                    2. Buscar contacto
                    3. Modificar contacto
                    4. Eliminar contacto
                    5. Mostrar contactos
                    6. Vaciar agenda
                    7. Salir
                    Opcion: """);

            opcion = scanner.next();

            switch (opcion) {
                case "1" -> anadirContacto();
                case "2" -> buscarContacto();
                case "3" -> modificarContacto();
                case "4" -> eliminarContacto();
                case "5" -> mostrarContacto();
                case "6" -> vaciarAgenda();
                case "7" -> System.exit(0);
                default -> System.out.println("Opción no contemplada");
            }
        } while (!opcion.equals("7"));
    }

    private static void anadirContacto() {
        if (cantidadContactos >= agenda.length) {
            System.out.println("La agenda está llena.");
            return;
        }

        System.out.println("Introduce un nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();

        System.out.println("Introduce un teléfono: ");
        String telefono = scanner.nextLine();

        
        for (int i = 0; i < cantidadContactos; i++) {
            if (agenda[i] != null && (nombre.equalsIgnoreCase(agenda[i].getNombre()) ||
                    telefono.equals(agenda[i].getTelefono()))) {
                System.out.println("Contacto existente.");
                return;
            }
        }

        
        agenda[cantidadContactos] = new Contacto(nombre, telefono);
        cantidadContactos++;
        System.out.println("Contacto almacenado correctamente.");
    }

    private static void buscarContacto() {
        System.out.println("Introduce el nombre a buscar: ");
        scanner.nextLine();
        String nombreBuscado = scanner.nextLine();

        for (int i = 0; i < cantidadContactos; i++) {
            if (agenda[i] != null && nombreBuscado.equalsIgnoreCase(agenda[i].getNombre())) {
                System.out.println("Contacto encontrado: " + agenda[i].getNombre() + " - " + agenda[i].getTelefono());
                return;
            }
        }
        System.out.println("El contacto no existe.");
    }

    private static void modificarContacto() {
        System.out.println("Introduce el nombre del contacto a modificar: ");
        scanner.nextLine();
        String nombreBuscado = scanner.nextLine();

        for (int i = 0; i < cantidadContactos; i++) {
            if (agenda[i] != null && nombreBuscado.equalsIgnoreCase(agenda[i].getNombre())) {
                System.out.println("Introduce el nuevo teléfono: ");
                String nuevoTelefono = scanner.nextLine();
                agenda[i].setTelefono(nuevoTelefono);
                System.out.println("Contacto actualizado.");
                return;
            }
        }
        System.out.println("El contacto no existe.");
    }

    private static void eliminarContacto() {
        System.out.println("Introduce el nombre del contacto a eliminar: ");
        scanner.nextLine();
        String nombreBuscado = scanner.nextLine();

        for (int i = 0; i < cantidadContactos; i++) {
            if (agenda[i] != null && nombreBuscado.equalsIgnoreCase(agenda[i].getNombre())) {
                agenda[i] = agenda[cantidadContactos - 1]; 
                agenda[cantidadContactos - 1] = null; 
                cantidadContactos--;
                System.out.println("Contacto eliminado.");
                return;
            }
        }
        System.out.println("El contacto no existe.");
    }

    private static void mostrarContacto() {
        if (cantidadContactos == 0) {
            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.println("\nLista de contactos:");
        for (int i = 0; i < cantidadContactos; i++) {
            if (agenda[i] != null) {
                System.out.println((i + 1) + ". " + agenda[i].getNombre() + " - " + agenda[i].getTelefono());
            }
        }
    }

    private static void vaciarAgenda() {
        for (int i = 0; i < cantidadContactos; i++) {
            agenda[i] = null;
        }
        cantidadContactos = 0;
        System.out.println("La agenda ha sido vaciada.");
    }
}
