/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maraloedev.clases;

/**
 *
 * @author Eduardo
 */
public class Productos {

    private int codigo;
    private String tipo;
    private String descripcion;
    private double precio;
    private int cantidad;

    public Productos(int codigo, String tipo, String descripcion,
            double precio, int cantidad) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return codigo + ": " + descripcion + " --> " + precio + " €";
    }
}
