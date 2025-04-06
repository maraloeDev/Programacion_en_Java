/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.Mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class AppClientes {

    static HashMap<Integer, Cliente> clientes;
    static Scanner scanner = new Scanner(System.in);

    public static boolean nuevoCliente(Cliente cliente) {
        
        //Añadir cliente al mapa
        clientes.put(cliente.getId(), cliente);
        return true;
    }

    public static boolean modificarCliente(int id, Cliente cliente) {
        Cliente c = clientes.get(id);

        //Si el id existe
        if (c !=null) {
            c.setDni(cliente.getDni());
            c.setEmpresa(cliente.getEmpresa());
            return true;
        }
        return false;
    }

    public static boolean eliminarCliente(int id) {
        Cliente c = clientes.get(id);

        if (c != null) {
            System.out.print("Estas seguro (S/N) ");
            char pregunta = scanner.nextLine().toUpperCase().charAt(0);

            if (pregunta == 'S') {
                clientes.remove(id);
            }
            return false;
        }
        return true;
    }

    public static void listarClientes() {
        for (Map.Entry<Integer, Cliente> listaCliente : clientes.entrySet()) {
            System.out.println("Clave " + " " + listaCliente.getKey());
            System.out.println("Valor " + " " + listaCliente.getValue().toString());

        }

    }

    public static Cliente findById(int id) {
        
        //Si el mapa de clientes contiene la key id
        if (clientes.containsKey(id)) {
            return clientes.get(id);
        } else {
            return null;
        }
    }

    public static ArrayList<Cliente> findByDni(String dni) {
        ArrayList<Cliente> resultado = new ArrayList<>();

        //Recorro el mapa, almaceno el value en una variable de tipo Cliente
        for (Map.Entry<Integer, Cliente> entry : clientes.entrySet()) {
            Cliente c = entry.getValue();
        //Luego comparo el dni actual con el pasado como parametro y lo añado
        // al AL
            if (c.getDni().equals(dni)) {
                resultado.add(c);
            }
        }

        return resultado.isEmpty() ? null : resultado;
    }

    public static void main(String[] args) {

        clientes = new HashMap<>();

        //1. Almacenamos clientes en el mapa
        nuevoCliente(new Cliente("11111111A", "CLIENTE1"));
        nuevoCliente(new Cliente("22222222B", "CLIENTE2"));
        nuevoCliente(new Cliente("33333333C", "CLIENTE3"));
        nuevoCliente(new Cliente("33333333C", "CLIENTE4"));
        nuevoCliente(new Cliente("33333333C", "CLIENTE5"));

        //2. Mostramos el mapa de clientes
        listarClientes();

        //3. Modificar cliente
        System.out.println("MODIFICAR CLIENTE");
        Cliente c = new Cliente("22222222B", "NUEVA EMPRESA");
        modificarCliente(2, c);

        listarClientes();

        System.out.println("BORRAR CLIENTE");
        //4. Borrar cliente del mapa
        if (eliminarCliente(1)) {
            System.out.println("Cliente eliminado");
        }

        listarClientes();

        System.out.println("BUSCAR POR ID");
        // 5. búsqueda por dni

        listarClientes();

        ArrayList<Cliente> clientes = findByDni("33333333C");
        if (clientes != null) {
            System.out.println(clientes);
        } else {
            System.out.println("No hay ningún cliente con ese dni");
        }
    }
}
