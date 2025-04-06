import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio02_EscribirUnTXT {

    /**
     * Ejercicio 2: Escribir un archivo TXT con información almacenada en un HashMap
     * Objetivo: Almacenar en un HashMap los nombres de productos y sus precios y escribirlos en un archivo TXT.
     *
     * Instrucciones:
     *
     * Crea un HashMap<String, Double> donde la clave es el nombre del producto y el valor es el precio.
     *
     * Añade algunos productos con precios.
     *
     * Escribe los contenidos del HashMap en un archivo TXT, con cada producto y precio en una nueva línea:

     * Producto1: 20.5
     * Producto2: 15.3
     */


    static HashMap<String, Double> listaPrecios = new HashMap<>();
    static File f  = new File("precios.txt");

    private static void escrituraTXT(File f) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {

            listaPrecios.put("Producto1", 20.0);
            listaPrecios.put("Producto2", 60.0);

            for (Map.Entry<String,Double> precios : listaPrecios.entrySet()) {
                bw.write(precios.toString() + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        escrituraTXT(f);
    }
}
