package com.maraloedev.clases;


public class TiposProductos {
    
    private int idTipo;
    private Character tipo;

    public TiposProductos(int idTipo, Character tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.valueOf(tipo);
    }
    
    
    
}
