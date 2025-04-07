package com.maraloedev.tema9.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu implements ActionListener {

    private EjemploMenu ventana;

    public ControladorMenu(EjemploMenu ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String accion = arg0.getActionCommand();
        ventana.getAreaTexto().append(accion + "\n");
        if (accion.equals("Salir")) {
            System.exit(0);
        }
    }
}
