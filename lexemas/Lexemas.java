package PruebasRepositorio2026.lexemas;

import java.util.ArrayList;

public class Lexemas {
    public static final int ID = 14;
    public static final int NUM = 7;

    public static final int IGUAL_IGUAL = 12;
    public static final int DIFERENTE_DE = 29;
    public static final int MENOR_IGUAL_QUE = 17;
    public static final int MENOR_QUE = 4;
    public static final int MAYOR_QUE = 50;
    public static final int MAYOR_IGUAL_QUE = 8;

    public static final int SUMA = 36;
    public static final int RESTA = 25;
    public static final int MULT = 41;
    public static final int DIVISION = 13;
    
    public static final int PUNTO = 20;
    public static final int COMA = 47;
    public static final int IGUAL = 33;
    public static final int PUNTO_COMA = 1;
    public static final int PARENTESIS_ABRE = 10;
    public static final int PARENTESIS_CIERRA = 26;

    public static String[] palabrasReservadas = {"const","begin","for","while"};
    public static ArrayList <String> palabraRes = new ArrayList<String>();
    public static void llenaPalRes() {
        palabraRes.add("do");
        palabraRes.add("then");
    }
    


    }
