import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio05 {

    /**
     * Ejercicio 5: Leer un archivo CSV y realizar operaciones en un HashMap
     * Objetivo: Leer un archivo CSV que contenga productos y cantidades, y almacenarlo en un HashMap. Luego, actualiza las cantidades de los productos.
     * <p>
     * Instrucciones:
     * <p>
     * Lee un archivo CSV con la siguiente estructura:
     * <p>
     * Producto1,10
     * Producto2,5
     * Producto3,7
     * <p>
     * Almacena cada producto y cantidad en un HashMap<String, Integer>.
     * <p>
     * Aumenta la cantidad de un producto específico (por ejemplo, Producto1 a 15).
     * <p>
     * Imprime el HashMap actualizado.
     */

    static HashMap<String, String> productos = new HashMap<>();
    static File f = new File("Productos.csv");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        lecturaCSV(f);
        escrribirCSV(f);
    }

    public static void lecturaCSV(File d) {

        try (CSVReader csvReader = new CSVReader(new FileReader(d))) {

            String[] linea = null;
            csvReader.readNext(); // Esta línea se salta la cabecera


            while ((linea = csvReader.readNext()) != null) {
                productos.put(linea[0], linea[1]);
            }

            for (Map.Entry<String, String> listaProds : productos.entrySet()) {
                System.out.println(listaProds);
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }

    public static void escrribirCSV(File e) {

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(e))) {

            System.out.print("Introduce el nombre del producto a cambiar: ");
            String producto = scanner.next();

            for(Map.Entry<String, String> listaProds : productos.entrySet()) {

                if (producto.equalsIgnoreCase(listaProds.getKey())) {
                    System.out.print("Introduce el nuevo precio: ");
                    int nuevoPrecio = scanner.nextInt();
                    listaProds.setValue(String.valueOf(nuevoPrecio));
                    break;
                }
                    System.out.println("Producto actualizado");

            }
            for(Map.Entry<String, String> listaProds : productos.entrySet()) {

            String[] line = {listaProds.getKey(), listaProds.getValue()};
            csvWriter.writeNext(line);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
