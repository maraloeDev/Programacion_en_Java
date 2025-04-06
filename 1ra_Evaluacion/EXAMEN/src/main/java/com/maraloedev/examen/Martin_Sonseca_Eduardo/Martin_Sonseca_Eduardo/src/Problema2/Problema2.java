package Problema2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Problema2 {

    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
    LocalDate localDate;

    public static void main(String[] args) {

        String nombreEvento = "";
        String fechaIntroducida = "";
        do {
            System.out.print("Introduce el nombre del evento(solo letras y espacios, 5-100 caracteres): ");
            nombreEvento = scanner.nextLine();
            
             if (nombreEvento.length() < 5 || nombreEvento.length() > 100) {
                System.out.println("La longitud del nombre del evvento tiene que ser mayor que 5");
            }
             
            System.out.print("Introduce la fecha del evento (dd-MM-yyyy):");
            fechaIntroducida = scanner.next();
            
            if (!fechaIntroducida.contains("-")) {
                System.out.println("Error. Fecha no valida. ");
            }



        } while ((nombreEvento.length() < 5 || nombreEvento.length() > 100) || !fechaIntroducida.contains("-"));

        System.out.println("Evento registrado correctamente");
        System.out.println("Nombre: " + nombreEvento);
        System.out.println("Fecha: " + fechaIntroducida);

    }
}
