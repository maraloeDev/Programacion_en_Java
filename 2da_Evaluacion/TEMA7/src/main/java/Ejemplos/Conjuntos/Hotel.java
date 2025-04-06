/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.Conjuntos;

/**
 *
 * @author Eduardo
 */
public class Hotel implements Comparable<Hotel>{
    
    private int id;
    private Zonas zona;
    private double precio;
    public static int contador;

    public Hotel(String zona, double precio) throws Exception {
        this.id = contador++;
        setZona(zona);
        setPrecio(precio);
    }

    public Zonas getZona() {
        return zona;
    }

    public void setZona(String zona) {
        try {
        this.zona = Zonas.valueOf(zona);
        } catch(IllegalArgumentException ex) {
            System.out.println("Error, Zona de hotel no permitida");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws Exception {
        
        if(precio < 40 || precio > 150) {
            throw new Exception("Error, precio del hotel fuera de rango");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", zona=" + zona + ", precio=" + precio + "\n";
    }

    @Override
    public int compareTo(Hotel o) {
        return (int) (this.getPrecio() - o.getPrecio());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        return this.zona == other.zona;
    }
    
    
    
    
}
