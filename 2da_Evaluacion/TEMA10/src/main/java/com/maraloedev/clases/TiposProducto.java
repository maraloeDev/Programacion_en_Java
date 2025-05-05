package com.maraloedev.clases;


public class TiposProducto {
    
    private int idTipo;
    private Character tipo;

    public TiposProducto(int idTipo, Character tipo) {
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
