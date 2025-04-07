package com.maraloedev.Ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio01 {
    
    public static void main(String[] args) {
        
        String archivo = "src\\main\\java\\com\\maraloedev\\Ejercicios\\FicherosCSV\\Datos1.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            
            String linea;
            int contador=1;
            int contadorLineasVacias=0;
            while((linea = br.readLine()) != null) {
                
                if(!linea.isEmpty()) {
                    
                System.out.println(contador + " " + linea);
                contador++;
                } else {
                    
                contadorLineasVacias++;
                }
            }
                System.out.println("Lineas vacias: " + contadorLineasVacias);
                br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
