package Problema3;

import java.time.LocalDate;

public class Usuario {

    int nUsuario = 1;

    //Atributos
    private int id;
    private String nombre;
    private String password;
    private LocalDate fecha;
    private double cuota;
    private boolean bloqueado;

    //Constructor sin atributos
    public Usuario() {
    }

    public Usuario(String nombre, String password, LocalDate fecha, double cuota, boolean bloqueado) {
        
        this.id = nUsuario++;
        this.nombre = nombre;
        this.password = "";
        this.fecha = LocalDate.now();
        this.cuota = 100;
        this.bloqueado = false;
    }

    public int getId() {
        return nUsuario;
    }

    public void setId(int id) {
        this.id = id;
    }
    
        
        

    public int getnUsuario() {
        return nUsuario;
    }

    public void setnUsuario(int nUsuario) {
        this.nUsuario = nUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public boolean isBloqueado() {
        
        if(bloqueado == true){
            System.out.println("X");
        } else {
            System.out.println("");
        }
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    //devuelve el password del usuario ocultado por el carácter pasado como parámetro. 
    private void ocultarPassword(char caracter) {
        
        

    }

    /**
     * disminuye la cuota de disco del usuario en 10 Mb. El usuario se
     * bloqueará, en el momento en que no disponga de cuota de disco.
     */
    private void consumirCuota() {
        
        this.cuota-=10;
        
        

    }

    //toString()
    @Override
    public String toString() {
        return "(<" + this.bloqueado + ">)" + "<" + this.nombre + "> (<" + this.getId() + ">)/" + "<" + this.password + ">:" + "<" + this.cuota + "> Mb";
    }

}
