package analizadorlexico.control;
import PruebasRepositorio2026.lexemas.Lexemas;
public class PruebasClase {
    public static void main(String[] args) {
        System.out.println(Lexemas.palabrasReservadas[0]);
        System.out.println(Lexemas.palabrasReservadas[1]);
        System.out.println(Lexemas.palabrasReservadas[2]);
        System.out.println(Lexemas.palabrasReservadas[3]);
        if (Lexemas.palabrasReservadas[0].equals("CONST")) {
            System.out.println("Son iguales");
        }//equals
        Lexemas.llenaPalRes();
        if (Lexemas.palabraRes.contains("do")){
            System.out.println("Si lo contiene");
        }//if contains 
    }
    
}
