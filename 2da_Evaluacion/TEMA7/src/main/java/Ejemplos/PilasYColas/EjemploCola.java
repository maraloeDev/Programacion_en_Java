/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.PilasYColas;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class EjemploCola {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> colaImpresion = new LinkedList();
        
        System.out.println("Introduce los archivos a imprimir: ");
        String archivo="";
        
        do {
            
            archivo = scanner.next();
            
            if(!archivo.equals("fin")) {
                colaImpresion.addLast(archivo);
            }
            
        } while (!archivo.equals("fin"));
        
        while(!colaImpresion.isEmpty()) {
            System.out.println("Imprimiendo... " + colaImpresion.removeFirst());
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EjemploCola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Archivos pendientes de imprimir: " + colaImpresion);
    }
}
