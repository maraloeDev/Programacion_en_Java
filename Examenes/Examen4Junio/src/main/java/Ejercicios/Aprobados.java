/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author Eduardo
 */
public class Aprobados {
    
    private int id_alumno;
    private double nota;

    public Aprobados(int id_alumno, double nota) {
        this.id_alumno = id_alumno;
        this.nota = nota;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "id_alumno=" + id_alumno + "\nNota=" + nota + '}';
    }
    
    
    
}
