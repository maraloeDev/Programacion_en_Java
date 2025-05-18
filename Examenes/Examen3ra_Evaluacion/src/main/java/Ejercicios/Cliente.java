package Ejercicios;


public class Cliente {
    
    private String cif_cliente;
    private String nombre_cliente;

    public Cliente(String cif_cliente, String nombre_cliente) {
        this.cif_cliente = cif_cliente;
        this.nombre_cliente = nombre_cliente;
    }

    public String getCif_cliente() {
        return cif_cliente;
    }

    public void setCif_cliente(String cif_cliente) {
        this.cif_cliente = cif_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cif_cliente=" + cif_cliente + ", nombre_cliente=" + nombre_cliente + '}';
    }
    
}
