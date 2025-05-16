package Ejercicios;


public class Probema03NoRecu {
    
    
    //La primera letra del código de stocks es la categoría del libro.
    static String[] listaStocks = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
    static String[] listaCategorias = {"A", "B", "C", "W"};
    
    public static void main(String[] args) {
        for(String categorias : listaCategorias) {
            int sumaStock=0;
            
            for(String stock : listaStocks) {
                //Separo la lista de stocks cuyo delimitador es un espacio
                String[] separacion = stock.split(" ");
                String codigo = separacion[0];
                String cantidad = separacion[1];
                
                /**
                 * Compruebo si el codigo (ya separado de la canidad) empieza
                 * por la categoria, si es asi, sumas el stock con la cantidad
                **/
                if(codigo.startsWith(categorias)) {
                    sumaStock+=Integer.parseInt(cantidad);
                }
            }
            System.out.print("("+categorias+":"+sumaStock+") - ");
        }
    }
    
}
