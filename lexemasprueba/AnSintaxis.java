package lexemasprueba;

import java.util.ArrayList;

public class AnSintaxis {
    private ArrayList<String> lexemas;
    private int tok;

    public AnSintaxis(ArrayList<String> lexemas) {
        this.lexemas = lexemas;
    }

    public static void getLexemasDeFuera(ArrayList<String> lexemas) {
        // this.lexemas = lexemas;
    }

    private int getNextToken() {
        // Aqui va el codigo para obtener el token actual de ArrayList lexemas
        return 0;
    }

    public void programa() {
        tok = getNextToken();
        bloque();
        if (tok != 32) { // 32 deberia de ser la constante . if (tok != Lex.PUNTO)
            System.out.println("Error");
        } else {
            System.out.println("Compilacion exitosa");
        }
    }

    public void bloque() {
        // Aqui va el codigo del bloque
    }
    // GLL
    /*
     * <Termino_Resto> -> * <Factor><Termino_Resto>
     * <Termino_Resto> -> / <Factor><Termino_Resto>
     * <Termino_Resto> -> NULL
     * 
     * First<Termino_Resto> = (* , /, NULL)
     */

    public void terminoResto() {
        // if (firstTerminoResto.contains(tok)
        if (tok == 5 || tok == 6) {
            return; // Programacion del NULL
        }
        tok = getNextToken();
        factor();
        terminoResto();
    }

    private void expresion() {
        //aqui va el codigo de la expresion
    }

    /*
     * <Factor> -> id
     * <Factor> -> num
     * <Factor> -> ( <Expresion> )
     */
    public void factor() {
        switch (tok) {
            case 100: // id
            case 200: // num
                tok = getNextToken();
                break;
            case 69:
                tok = getNextToken();
                expresion();
                if (tok != 70) {
                    //Errores.showError(12, tok, lexemas.get(idx), linea); buen manejo de errores
                    System.out.println("Error se esperaba )");
                    return;
                }
                tok = getNextToken();
            default:
                System.out.println("Error se esperaba First(Factor)");

        }
    }
}
