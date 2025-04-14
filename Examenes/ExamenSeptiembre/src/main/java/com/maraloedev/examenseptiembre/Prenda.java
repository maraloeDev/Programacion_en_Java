package com.maraloedev.examenseptiembre;


public class Prenda {
    
    private String descripcion;
    private char talla;
    private String color;
    private double precio;

    public Prenda() {
    }

    public Prenda(String descripcion, char talla, String color, double precio) {
        this.descripcion = descripcion;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getTalla() {
        return talla;
    }

    public void setTalla(char talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return descripcion + "  " + talla +  "  " + color +  "  " + precio;
    }
}
