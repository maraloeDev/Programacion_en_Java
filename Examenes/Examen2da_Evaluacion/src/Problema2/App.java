/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problema2;

import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class App {

    static Scanner scanner = new Scanner(System.in);
    static Cuenta c1 = new Cuenta("1111112A", 15000, 20);

    public static void main(String[] args) {
        
        int opcion=0;
        do {
            System.out.println("Indica que quiere hacer\n 1-Ingresar dinero\n 2-Retirar dinero\n 3- Comprobar saldo");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Introduce un saldo a ingresar: ");
                double ingresarSaldo = scanner.nextDouble();
                c1.ingresarDinero(ingresarSaldo);
                break;
            case 2:
                System.out.print("Introduce un saldo a retirar: ");
                double retirarSaldo = scanner.nextDouble();
                c1.retirarDinero(retirarSaldo);
                break;

            case 3:
                System.out.println("El saldo actual es de " + c1.getSaldo());
                break;
        }
        } while (opcion!=4);
    }

}
