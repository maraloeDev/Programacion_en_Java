package com.maraloedev.tema9.componentes;

import javax.swing.*;

/**
 *
 * @author macarena
 * 
 * Este ejemplo est� picado todo el c�digo, no se usa la vista Design.
 * 
 */

public class EjemploJOptionPane extends JFrame {

    public EjemploJOptionPane() {
        JOptionPane.showMessageDialog(this, "Soy un mensaje de informacion", "Cuadro de informacion",
                JOptionPane.INFORMATION_MESSAGE);

        int res = JOptionPane.showConfirmDialog(this, "�Desea salir?", "Cuadro de confirmacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (res == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

        String res2 = JOptionPane.showInputDialog("Escriba su nombre");
        if (res2 == null) {
            JOptionPane.showMessageDialog(this, "No escribio nada");
        } else {
            System.out.println("Has escrito " + res2);
        }

        String opciones[] = {"Espa�a", "Italia", "Francia", "Portugal"};
        String res3 = (String) JOptionPane.showInputDialog(this, "Elige tu pais", "Cuadro de seleccion",
                JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        System.out.println("Has elegido " + res3);
    }

    public static void main(String[] args) {
        EjemploJOptionPane ej = new EjemploJOptionPane();
    }
}
