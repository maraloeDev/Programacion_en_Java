public class Ejercicio01 {

    private String nombre;
    private String edad;
    private String puesto;

    public Ejercicio01(String nombre, String edad, String puesto) {
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


    public String[] toCSV() {
        return new String[] { nombre, edad, puesto };
    }
}
