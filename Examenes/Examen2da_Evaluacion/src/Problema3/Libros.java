/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problema3;

/**
 *
 * @author Eduardo
 */
public class Libros {

    //Creacion de los stocks y las categorias
    static String[] listaStocks = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
    static String[] listaCategorias = {"A", "B", "C", "W"};

    public static void main(String[] args) {

        //Recorro todas las categorias  donde almaceno la suma de cada
        for (String categorias : listaCategorias) {
            int sumaStock = 0;

            // Recorro cada stock localizando el caracter separador y realizando
            //una condicion en que si la categoria empieza por alguna categoria
            //de la lista me sumas el stock y la cantidad
            for (String stocks : listaStocks) {
                String[] stock = stocks.split(" ");
                String categoria = stock[0];
                String cantidad = stock[1];

                if (categoria.startsWith(categorias)) {
                    sumaStock += Integer.parseInt(cantidad);
                }
            }

            System.out.print("(" + categorias + ":" + sumaStock + ") - ");
        }
    }
}
