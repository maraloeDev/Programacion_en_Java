package com.maraloedev.Ejemplos;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class EjemploJFileChooser {

    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int respuesta = fileChooser.showOpenDialog(null);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile(); //Devuelve el archivo/directory seleccionado por el usuario
            System.out.println("Archivo seleccionado: " + archivoSeleccionado);
        } else {
            System.out.println("seleccion cancelada");
        }
        
        //Seleccionar solo imagenes
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "gif"));
        
        //Seleccionar solo diectorios
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }
}
