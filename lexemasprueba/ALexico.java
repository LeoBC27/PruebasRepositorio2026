package lexemasprueba;

import java.util.ArrayList;

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

    // Palabras Reservadas
    public static final int CONST = 42;
    public static final int VAR = 3;
    public static final int PROCED = 27;
    public static final int BEGIN = 19;
    public static final int END = 5;
    public static final int IF = 38;
    public static final int THEN = 11;
    public static final int WHILE = 45;
    public static final int DO = 22;
    public static final int FOR = 9;
    public static final int TO = 31;
    public static final int DOWN = 16;
    public static final int READ = 48;
    public static final int WRITE = 2;
    public static final int CALL = 34;

    public static String[] palabrasReservadas = { "const", "begin", "for", "while", "var" };
    public static ArrayList<String> palabraRes = new ArrayList<String>();

    public static void llenaPalRes() {
        palabraRes.add("do");
        palabraRes.add("then");
    }

}
