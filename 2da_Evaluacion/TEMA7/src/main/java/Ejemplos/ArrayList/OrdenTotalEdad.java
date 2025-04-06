/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.ArrayList;

import java.util.Comparator;

/**
 *
 * @author Eduardo
 */
public class OrdenTotalEdad implements Comparator<Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getEdad() - o2.getEdad();
    }
    
}
