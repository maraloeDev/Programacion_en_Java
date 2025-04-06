package Problema3;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        Usuario u = new Usuario("Matias", "password", LocalDate.now(), 100, true);
        Usuario u2 = new Usuario("Pepe", "paco", LocalDate.now(), 100, true);
        Usuario u3 = new Usuario("Locas", "papa", LocalDate.now(), 100, true);

        System.out.println("ID " + u.getId());
        System.out.println("Nombre " + u.getNombre());
        System.out.println("Password " + u.getPassword());
        System.out.println("Fecha de creacion " + u.getFecha());
        System.out.println("Bloqueado " + u.isBloqueado());
        
        System.out.println("-----------------------------------------");

        System.out.println("ID " + u2.getId());
        System.out.println("Nombre " + u2.getNombre());
        System.out.println("Password"  + u2.getPassword());
        System.out.println("Fecha de creacion " + u2.getFecha());
        System.out.println("Bloqueado " + u2.isBloqueado());
        
        System.out.println("-----------------------------------------");

        System.out.println("ID " + u3.getId());
        System.out.println("Nombre " + u3.getNombre());
        System.out.println("Password " + u3.getPassword());
        System.out.println("Fecha de creacion " + u3.getFecha());
        System.out.println("Bloqueado " + u3.isBloqueado());
        
        System.out.println("-----------------------------------------");

        System.out.println(        u.toString());        
        System.out.println(u2.toString());
        System.out.println(u3.toString());
        
    }

}
