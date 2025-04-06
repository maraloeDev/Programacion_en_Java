/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Eduardo
 */
public class AppPersonas {
    
    static ArrayList<Persona> listaPersonas = new ArrayList<>();
    
    public static void main(String[] args) {
        
        // Ver el contenido del AL
        System.out.println(listaPersonas);
        
        //Añadir objetos al arrayList
        listaPersonas.add(new Persona("12345678X", "Persona1", "apellidos1", 20));
        listaPersonas.add(new Persona("12345678X", "Persona2", "apellidos2", 28));
        listaPersonas.add(new Persona("12345678X", "Persona3", "apellidos3", 34));
        listaPersonas.add(new Persona("12345678X", "Persona4", "apellidos4", 12));
        listaPersonas.add(new Persona("12345678X", "Persona5", "apellidos5", 78));
        
        System.out.println(listaPersonas);
        
        //Recorrer el arraylist
        //Recorrer el arraylist por posicion
        System.out.println("RECORRER EL ARRAYLIST POR POSICION");
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona p = listaPersonas.get(i);
            System.out.println("Persona " + p);
            
        }
        //Recorrer el arraylist por referencia
        System.out.println("RECORRER EL ARRAYLIST POR REFERENCIA");
        for(Persona p : listaPersonas) {
            System.out.println(p);
        }
        
        //Recorrer el arraylist por iterador devuelve un objeto iterador de Personas
        System.out.println("RECORRER EL ARRAYLIST POR ITERADOR");
        Iterator<Persona> it = listaPersonas.iterator();
        
        while(it.hasNext()) {
            Persona p = it.next();
            System.out.println(p);
        }
        
        // Busqueda en el arraylist
        boolean encontrado= listaPersonas.contains(new Persona("12345678X", "Persona2", "apellidos2", 28));
        System.out.println(encontrado);
        
        //Si se encuentra aparece un 0
        int pos = listaPersonas.indexOf(new Persona("12345678X", "Persona1", "apellidos1", 20));
        System.out.println(pos);
        
        //Si no se encuentra aparece un -1
        pos = listaPersonas.indexOf(new Persona("12345678A", "Persona1", "apellidos1", 20));
        System.out.println(pos);
        
        //Eliminar personas por objeto
        boolean borrado =listaPersonas.remove(new Persona("12345678X", "Persona5", "apellidos5", 78));
        System.out.println(borrado);
        System.out.println(listaPersonas);
        
        //Eliminar personas por posicion
        Persona personaEliminada = listaPersonas.remove(3);
        System.out.println(personaEliminada);
        System.out.println(listaPersonas);
        
        //Ordenar el arrayList
        
        Collections.sort(listaPersonas);
        System.out.println(listaPersonas);
        
        Collections.sort(listaPersonas, new OrdenTotalEdad());
        System.out.println(listaPersonas);
        
        // revierte el orden de la lista
        Collections.reverse(listaPersonas);
        System.out.println(listaPersonas);
        
        pos = Collections.binarySearch(listaPersonas, new Persona("12345678X"));
        System.out.println("Esta esta persona " + pos);
        System.out.println(listaPersonas);
    }
}
