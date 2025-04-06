import java.io.*;
import java.util.ArrayList;

public class Ejercicio03_LeerUnArchivoTXT {

    /**
     * Ejercicio 3: Leer un archivo TXT y almacenarlo en un ArrayList
     * Objetivo: Leer un archivo de texto línea por línea y almacenar cada línea en un ArrayList.
     *
     * Instrucciones:
     *
     * Crea un archivo TXT con varias líneas de texto.
     *
     * Usa un BufferedReader para leer el archivo y almacenar cada línea en un ArrayList.
     *
     * Imprime el contenido del ArrayList.
     */

    static File f = new File("Ejercicio03.txt");
    static ArrayList<String> listaPalabras = new ArrayList<>();

    public static void leerArchivo(File f) {

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

             String linea = null;

             while ((linea= br.readLine())!=null) {
                 listaPalabras.add(linea);
             }

             for(String listaCompleta: listaPalabras) {
                 System.out.println(listaCompleta );
             }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        leerArchivo(f);


    }
}
