/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problema2;

/**
 *
 * @author Eduardo
 */
public class CuentaCorriente  extends Cuenta {
    
    private double descubiertos;

    public CuentaCorriente(String numero_Cuenta, double saldo, int comision) {
        super(numero_Cuenta, saldo, comision);
    }

    public double getDescubiertos() {
        return descubiertos;
    }

    public void setDescubiertos(double descubiertos) {
        this.descubiertos = descubiertos;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" + "descubiertos=" + descubiertos + '}';
    }
}
