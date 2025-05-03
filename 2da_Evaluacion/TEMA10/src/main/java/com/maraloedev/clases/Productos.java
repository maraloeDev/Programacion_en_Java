package com.maraloedev.clases;

public class Productos {

    private int idProducto;
    private String descripcion;
    private Double precio;
    private int cantidad;
    private int tipo;

    public Productos(int idProducto, String descripcion, Double precio, int cantidad, int tipo) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return idProducto + ": " + descripcion + " --> " + precio + " €";
    }

}
