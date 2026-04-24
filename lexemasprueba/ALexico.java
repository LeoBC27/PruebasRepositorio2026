package lexemasprueba;

public class ALexico {
    // Identificadores y Literales
    public static final int ID = 1;
    public static final int NUM = 2;

    // Operadores Relacionales
    public static final int IGUAL_IGUAL = 11;
    public static final int DIFERENTE_DE = 12;
    public static final int MENOR_IGUAL_QUE = 13;
    public static final int MENOR_QUE = 14;
    public static final int MAYOR_QUE = 15;
    public static final int MAYOR_IGUAL_QUE = 16;

    // Operadores Aritméticos
    public static final int SUMA = 21;
    public static final int RESTA = 22;
    public static final int MULT = 23;
    public static final int DIV = 24;

    // Simbolos especiales y Puntuación
    public static final int PUNTO = 31;
    public static final int COMA = 32;
    public static final int IGUAL = 33;
    public static final int PUNTO_COMA = 34; 
    public static final int PARENTESIS_ABRE = 35;
    public static final int PARENTESIS_CIERRA = 36;

    public static int esReservada(String palabra) {
        int res = 14; // Si no la encuentra es un ID normal (14)
        
        String[] reservadas = {"const","var","proced","begin","end","if","then","while","do","for","to","down","read","write","call"};
        int[] valores = {41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55};
        
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