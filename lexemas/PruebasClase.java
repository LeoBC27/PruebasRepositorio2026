package PruebasRepositorio2026.lexemas;

public class PruebasClase {
        public static void main(String[] args) {
        /* 
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
        } */
        Lexema l1 = new Lexema("Computadora", "Portatil");
        System.out.println(l1);
    }
    public static  int esReservada(String palabra){
        int res = -1;
        String[] reservadas = {"const","if","var","while"};
        palabra = palabra.toLowerCase();
        for (int i = 0 ; i < reservadas.length ; i++){
            if (palabra.equals(reservadas[i])) {
                return i+1;
            }
        }
        return res;
    }
    
}

    