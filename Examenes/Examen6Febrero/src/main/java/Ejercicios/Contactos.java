package Ejercicios;


public class Contactos {
    
    private int id;
    private String nombre;
    private String tf;

    public Contactos(int id, String nombre, String tf) {
        this.id = id;
        this.nombre = nombre;
        this.tf = tf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Contactos{" + "id=" + id + ", nombre=" + nombre + ", tf=" + tf + '}';
    }
  
    
    
    
}
