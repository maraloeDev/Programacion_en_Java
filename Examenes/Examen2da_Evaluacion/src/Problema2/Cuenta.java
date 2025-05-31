/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problema2;

/**
 *
 * @author Eduardo
 */
public class Cuenta {
    
    private String numero_Cuenta;
    private double saldo;
    private int comision;

    public Cuenta(String numero_Cuenta, double saldo, int comision) {
        this.numero_Cuenta = numero_Cuenta;
        this.saldo = saldo;
        this.comision = comision;
    }

    public String getNumero_Cuenta() {
        return numero_Cuenta;
    }

    public void setNumero_Cuenta(String numero_Cuenta) {
        this.numero_Cuenta = numero_Cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numero_Cuenta=" + numero_Cuenta + ", saldo=" + saldo + ", comision=" + comision + '}';
    }
    
    public void ingresarDinero(double saldo) {
        if(saldo <=0) {
            System.out.println("No puedes introducir valores negativos");
        } else {
            setSaldo(getSaldo() + saldo);
        }    
    }
    
    public void retirarDinero(double saldo) {
        if(saldo > getSaldo()) {
            System.out.println("Cuenta al descubierto con el saldo " + getSaldo());
            
        } else {
            setSaldo(getSaldo() - saldo);
        }    
    }
}
