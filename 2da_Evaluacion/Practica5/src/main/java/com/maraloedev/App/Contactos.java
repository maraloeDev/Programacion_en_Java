package com.maraloedev.App;

public class Contactos {

    private int idContacto;
    private String nombre;
    private String tf;

    public Contactos(int idContacto, String nombre, String tf) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.tf = tf;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTf() {
        return tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    @Override
    public String toString() {
        return "idContacto=" + idContacto
                + "nombre=" + nombre
                + "Telefono=" + tf;
    }

}
