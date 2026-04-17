package lexemasprueba;

public class ALexico {
    // Identificadores y Literales
    public static final int ID = 14;
    public static final int NUM = 7;

    // Operadores Relacionales
    public static final int IGUAL_IGUAL = 12;
    public static final int DIFERENTE_DE = 29;
    public static final int MENOR_IGUAL_QUE = 17;
    public static final int MENOR_QUE = 4;
    public static final int MAYOR_QUE = 50;
    public static final int MAYOR_IGUAL_QUE = 8;

    // Operadores Aritméticos
    public static final int SUMA = 36;
    public static final int RESTA = 25;
    public static final int MULT = 41;
    public static final int DIV = 13;

    // Simbolos especiales y Puntuación
    public static final int PUNTO = 20;
    public static final int COMA = 47;
    public static final int IGUAL = 33;
    public static final int PUNTO_COMA = 1; 
    public static final int PARENTESIS_ABRE = 10;
    public static final int PARENTESIS_CIERRA = 26;

    public static int esReservada(String palabra) {
        int res = 14; // Si no la encuentra es un ID normal (14)
        
        String[] reservadas = {"const","var","proced","begin","end","if","then","while","do","for","to","down","read","write","call"};
        int[] valores = {42, 3, 27, 19, 5, 38, 11, 45, 22, 9, 31, 16, 48, 2, 34};
        
        palabra = palabra.toLowerCase();
        
        for (int i = 0 ; i < reservadas.length ; i++){
            if (palabra.equals(reservadas[i])) {
                return valores[i];
            }
        }
        return res;
    }
    public static int obtenerTokenSimbolo(String simbolo) {
        switch (simbolo) {
            case "==": return IGUAL_IGUAL;
            case "!=": return DIFERENTE_DE;
            case "<=": return MENOR_IGUAL_QUE;
            case ">=": return MAYOR_IGUAL_QUE;
            case "<":  return MENOR_QUE;
            case ">":  return MAYOR_QUE;
            case "=":  return IGUAL;
            case "+":  return SUMA;
            case "-":  return RESTA;
            case "*":  return MULT;
            case "/":  return DIV;
            case ".":  return PUNTO;
            case ",":  return COMA;
            case ";":  return PUNTO_COMA;
            case "(":  return PARENTESIS_ABRE;
            case ")":  return PARENTESIS_CIERRA;
            default:   return 0;
        }
    }
}