/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.Clases;

/**
 *
 * @author Eduardo
 */
public class Cliente {
    
    static int contador = 1;
    private int id;
    private String dni;
    private String nombre;
    
    
    

    public Cliente(String dni, String nombre) {
        this.id = contador++;
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return ""
                + "Id: " + id + "\n"
                + "DNI: " + dni + "\n"
                + "Nombre: " + nombre;
    }

}
