/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.Conjuntos;

import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class AppHotel {
    
    public static Set<Hotel> hoteles = new HashSet<>();
    
    public static void crearHoteles() {
        try {
            hoteles.add(new Hotel("PLAYA", 100));
            hoteles.add(new Hotel("MONTAÑA", 120));
            hoteles.add(new Hotel("RURAL", 100));
            hoteles.add(new Hotel("PLAYA", 90));
            hoteles.add(new Hotel("MONTAÑA", 135));
            hoteles.add(new Hotel("RURAL", 150));
            hoteles.add(new Hotel("MONTAÑA", 75));
            hoteles.add(new Hotel("RURAL", 85));
            hoteles.add(new Hotel("MONTAÑA", 110));
            hoteles.add(new Hotel("RURAL", 50));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void listarHoteles_1() {
        
        for (Hotel hotel : hoteles) {
            System.out.println(hotel);
        }
    }
    
    public static void listarHoteles_2() {
        
        Iterator<Hotel> it = hoteles.iterator();
        
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public static Set<Hotel> buscarHoteles(String zona) {
        Set<Hotel> hotelesPrecio = new TreeSet<>();
        Iterator<Hotel> it = hoteles.iterator();
        while (it.hasNext()) {
            Hotel hotel = it.next();
            
            if (hotel.getZona().equals(Zonas.valueOf(zona))) {
                hotelesPrecio.add(hotel);
            }
        }
        return hotelesPrecio;
    }
    
    public static void main(String[] args) {
        
        crearHoteles();
        System.out.println(hoteles);
        //listarHoteles_1();
        //listarHoteles_2();
        
        Set<Hotel> coincidencia = buscarHoteles("PLAYA");
        System.out.println(coincidencia);
    }
    
}
