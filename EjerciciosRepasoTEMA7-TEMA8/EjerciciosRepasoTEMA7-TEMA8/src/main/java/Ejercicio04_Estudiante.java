public class Ejercicio04_Estudiante {

    private String nombre;
    private int calificacion;

    public Ejercicio04_Estudiante(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String[] toCSV() {
        return new String[]{nombre, String.valueOf(calificacion)};
    }
}

