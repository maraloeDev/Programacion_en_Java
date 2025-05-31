/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.martin_sonseca_eduardo.problema1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class Semaforo {
    
    private String rojo;
    private String amarillo;
    private String verde;

    public Semaforo(String rojo, String amarillo, String verde) {
        this.rojo = rojo;
        this.amarillo = amarillo;
        this.verde = verde;
    }

    public String getRojo() {
        return rojo;
    }

    public void setRojo(String rojo) {
        this.rojo = rojo;
    }

    public String getAmarillo() {
        return amarillo;
    }

    public void setAmarillo(String amarillo) {
        this.amarillo = amarillo;
    }

    public String getVerde() {
        return verde;
    }

    public void setVerde(String verde) {
        this.verde = verde;
    }
    
    public void aRojo() {
        System.out.println("\\uD83D\\uDD34");
    }
    
    public void aVerde() {
        System.out.println("\\uD83D\\uDFE2");
    }
    
    public void aAmarillo() {
        System.out.println("\\uD83D\\uDFE1");
    }
    
    public void generarCiclo(int segundos) {
        
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException ex) {
            Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
