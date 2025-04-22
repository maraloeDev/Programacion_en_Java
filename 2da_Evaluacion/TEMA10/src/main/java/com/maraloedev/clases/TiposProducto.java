/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maraloedev.clases;

/**
 *
 * @author Eduardo
 */
public class TiposProducto {
    
    private int idTipo;
    private String tipo;

    public TiposProducto(int idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TiposProducto{" + "idTipo=" + idTipo + ", tipo=" + tipo + '}';
    }    
}
