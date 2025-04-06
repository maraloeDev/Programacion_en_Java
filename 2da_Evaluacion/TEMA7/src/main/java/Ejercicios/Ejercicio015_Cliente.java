package Ejercicios;

import Ejercicios.Clases.Cliente;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio015_Cliente {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static HashMap<Integer, Cliente> mapaClientes = new HashMap<>();

    public static void main(String[] args) {
        mapaClientes.clear();
        menu();
    }

    private static void menu() {
        String opcion;
        do {

            System.out.println("""
                           1. Introducir clientes en el mapa. 
                           2. Modificar los datos de un cliente (a excepcion de su id). 
                           3. Eliminar clientes del mapa. 
                           4. Buscar clientes por id y por dni. 
                           5. Mostrar todos los clientes del mapa."
                           6. Salir"
                           Introduce una opcion: """);
            opcion = scanner.next();

            switch (opcion) {
                case "1":
                    introducirClientes();
                    break;
                case "2":
                    modificarClientes();
                    break;
                case "3":
                    eliminarClientes();
                    break;
                case "4":
                    buscarClientes();
                    break;
                case "5":
                    mostrarClientes();
                    break;
                case "6":
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opcion no conemplada");
            }
        } while (!opcion.equals("6"));
    }

    private static void introducirClientes() {
        Integer nCIF = random.nextInt(1111111, 9999999);

        String dni;
        do {
            System.out.print("Introduce un DNI (8 números y 1 letra): ");
            dni = scanner.next();
            //Tiene que haber 8 digitos y letras de la AZ
        } while (!dni.matches("\\d{8}[a-zA-Z]"));

        System.out.print("Introduce un nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();

        mapaClientes.put(nCIF, new Cliente(dni, nombre));
        System.out.println("Cliente introducido correctamente");
    }

    private static void modificarClientes() {

        System.out.print("Introduce el id del cliente a modificar: ");
        int id = scanner.nextInt();
        boolean modificado = true;

        for (Map.Entry<Integer, Cliente> modCliente : mapaClientes.entrySet()) {
            if (modCliente.getValue().getId() == id) {
                modificado = true;
                System.out.println("Cliente encontrado: " + modCliente.getValue().getNombre());

                String dni;
                do {
                    System.out.print("Introduce un DNI (8 números y 1 letra): ");
                    dni = scanner.next();
                    //Tiene que haber 8 digitos y letras de la AZ
                } while (!dni.matches("\\d{8}[a-zA-Z]"));

                System.out.print("Introduce un nombre: ");
                scanner.nextLine();
                String nombre = scanner.nextLine();

                modCliente.getValue().setDni(dni);
                modCliente.getValue().setNombre(nombre);
                System.out.println("Cliente modificado correcrtamente");
                break;
            }
        }

        if (!modificado) {
            System.out.println("No se ha modificado el cliente con ese ID");
        }
    }

    private static void eliminarClientes() {

        System.out.print("Introduce el id del cliente a eliminar: ");
        int id = scanner.nextInt();
        boolean eliminado = true;

        for (Map.Entry<Integer, Cliente> eliminarCliente : mapaClientes.entrySet()) {
            if (eliminarCliente.getValue().getId() == id) {
                eliminado = true;
                System.out.println("Cliente eliminado");
                mapaClientes.remove(eliminarCliente.getKey());
                break;
            }
        }

    }

    private static void buscarClientes() {

        System.out.print("Introduce el id del cliente a modificar: ");
        int id = scanner.nextInt();
        boolean encontrado = true;

        for (Map.Entry<Integer, Cliente> modCliente : mapaClientes.entrySet()) {
            if (modCliente.getValue().getId() == id) {
                encontrado = true;
                System.out.println("Cliente encontrado: " + modCliente.getValue().getNombre());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se ha encontrado el cliente con ese ID");
        }
    }

    private static void mostrarClientes() {

        for (Map.Entry<Integer, Cliente> listadoClientes : mapaClientes.entrySet()) {
            System.out.println("CIF: " + listadoClientes.getKey());
            System.out.println(listadoClientes.getValue().toString());
        }
    }
}
