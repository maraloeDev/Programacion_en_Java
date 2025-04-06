/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.Clases;

/**
 *
 * @author Eduardo
 */
public class Contacto {

    private int id;
    private String nombre;
    private String telefono;
    static int contador = 1;

    public Contacto(String nombre, String telefono) {
        this.id = contador++;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return ""
                + "Id: " + id + "\n"
                + "Nombre: " + nombre + "\n"
                + "Telefono: " + telefono;
    }
}
