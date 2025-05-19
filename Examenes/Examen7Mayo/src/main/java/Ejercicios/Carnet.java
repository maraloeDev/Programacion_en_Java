/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author Eduardo
 */
public class Carnet {
    
    private int codigo;
    private String titular;
    private int puntos;

    public Carnet(int codigo, String titular, int puntos) {
        this.codigo = codigo;
        this.titular = titular;
        this.puntos = puntos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Carnet{" + "codigo=" + codigo + ", titular=" + titular + ", puntos=" + puntos + '}';
    }
    
    
    
}
