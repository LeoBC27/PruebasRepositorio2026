package lexemasprueba;

import java.util.ArrayList;

public class ASintactico {
    private ArrayList<String> lexemas;
    private int tok;
    private int index = 0; // Para llevar el control del token actual

    public ASintactico(ArrayList<String> lexemas) {
        this.lexemas = lexemas;
    }

    private int getNextToken() {
        if (index < lexemas.size()) {
            String lexemaActual = lexemas.get(index++);
            // Verificamos si es reservada, si no, intentamos obtener su símbolo
            int tokenReservada = ALexico.esReservada(lexemaActual);
            if (tokenReservada != 14) { 
                return tokenReservada;
            }
            
            int tokenSimbolo = ALexico.obtenerTokenSimbolo(lexemaActual);
            if (tokenSimbolo != 0) {
                return tokenSimbolo;
            }

            // Si es numérico
            if (lexemaActual.matches("\\d+")) {
                return ALexico.NUM;
            }

            // Por defecto asumimos que es un ID
            return ALexico.ID;
        }
        return -1; // Fin de archivo o lista
    }

    // Método auxiliar para comparar y avanzar
    private void match(int esperado) {
        if (tok == esperado) {
            tok = getNextToken();
        } else {
            System.out.println("Error de sintaxis. Se esperaba el token: " + esperado + " pero se encontró: " + tok);
        }
    }

    public void programa() {
        tok = getNextToken();
        bloque();
        if (tok != ALexico.PUNTO) {
            System.out.println("Error: Se esperaba un '.' al final del programa.");
        } else {
            System.out.println("Compilacion exitosa");
        }
    }

    public void bloque() {
        linealC();
        linealV();
        linealP();
        proposicion();
    }

    // <LinealC> -> const <CicloNum> ; | ∅
    public void linealC() {
        if (tok == 41) { // 41 es 'const'
            match(41);
            cicloNum();
            match(ALexico.PUNTO_COMA);
        }
        // Si no es 'const', es ∅ (producción vacía), simplemente retornamos
    }

    // <CicloNum> -> id = num <CicloNumPrima>
    public void cicloNum() {
        match(ALexico.ID);
        match(ALexico.IGUAL);
        match(ALexico.NUM);
        cicloNumPrima();
    }

    // <CicloNumPrima> -> , <CicloNum> | ∅
    public void cicloNumPrima() {
        if (tok == ALexico.COMA) {
            match(ALexico.COMA);
            cicloNum();
        }
    }

    // <LinealV> -> var <CicloId> ; | ∅
    public void linealV() {
        if (tok == 42) { // 42 es 'var'
            match(42);
            cicloId();
            match(ALexico.PUNTO_COMA);
        }
    }

    // <CicloId> -> id <CicloIdPrima>
    public void cicloId() {
        match(ALexico.ID);
        cicloIdPrima();
    }

    // <CicloIdPrima> -> , <CicloId> | ∅
    public void cicloIdPrima() {
        if (tok == ALexico.COMA) {
            match(ALexico.COMA);
            cicloId();
        }
    }

    // <LinealP> -> proced id ; <Bloque> ; <LinealP> | ∅
    public void linealP() {
        if (tok == 43) { // 43 es 'proced'
            match(43);
            match(ALexico.ID);
            match(ALexico.PUNTO_COMA);
            bloque();
            match(ALexico.PUNTO_COMA);
            linealP();
        }
    }

    // <Condicion> -> <Expresion> <MultSigno> <Expresion>
    public void condicion() {
        expresion();
        multSigno();
        expresion();
    }

    // <MultSigno> -> == | != | < | > | <= | >=
    public void multSigno() {
        if (tok == ALexico.IGUAL_IGUAL || tok == ALexico.DIFERENTE_DE || 
            tok == ALexico.MENOR_QUE || tok == ALexico.MAYOR_QUE || 
            tok == ALexico.MENOR_IGUAL_QUE || tok == ALexico.MAYOR_IGUAL_QUE) {
            match(tok);
        } else {
            System.out.println("Error: Se esperaba un operador relacional.");
        }
    }

    // <Proposicion> -> begin <CicloProp> end | id = <Expresion> | write <DisyWri> | ...
    public void proposicion() {
        switch (tok) {
            case 44: // begin
                match(44);
                cicloProp();
                match(45); // end
                break;
            case ALexico.ID: // id
                match(ALexico.ID);
                match(ALexico.IGUAL);
                expresion();
                break;
            case 54: // write
                match(54);
                disyWri();
                break;
            case 53: // read
                match(53);
                match(ALexico.ID);
                break;
            case 55: // call
                match(55);
                match(ALexico.ID);
                break;
            case 46: // if
                match(46);
                condicion();
                match(47); // then
                proposicion();
                break;
            case 48: // while
                match(48);
                expresion(); // Usando <Expresion> según tu regla general de proposición
                match(49); // do
                proposicion();
                break;
            case 50: // for
                match(50);
                match(ALexico.ID);
                match(ALexico.IGUAL);
                expresion();
                disyExp();
                expresion();
                match(49); // do
                proposicion();
                break;
            default:
                System.out.println("Error: Proposicion no valida. Encontrado: " + tok);
                break;
        }
    }

    // <DisyWri> -> id | num
    public void disyWri() {
        if (tok == ALexico.ID) {
            match(ALexico.ID);
        } else if (tok == ALexico.NUM) {
            match(ALexico.NUM);
        } else {
            System.out.println("Error: Se esperaba ID o NUM en write.");
        }
    }

    // <DisyExp> -> to | down
    public void disyExp() {
        if (tok == 51) { // to
            match(51);
        } else if (tok == 52) { // down
            match(52);
        } else {
            System.out.println("Error: Se esperaba 'to' o 'down'.");
        }
    }

    // <CicloProp> -> <Proposicion> <CicloPropPrima>
    public void cicloProp() {
        proposicion();
        cicloPropPrima();
    }

    // <CicloPropPrima> -> ; <CicloProp> | ∅
    public void cicloPropPrima() {
        if (tok == ALexico.PUNTO_COMA) {
            match(ALexico.PUNTO_COMA);
            cicloProp();
        }
    }

    // <Expresion> -> <Termino> <Exp_prima>
    public void expresion() {
        termino();
        expPrima();
    }

    // <Exp_prima> -> <DisySig> <Expresion> | ∅
    public void expPrima() {
        if (tok == ALexico.SUMA || tok == ALexico.RESTA) {
            disySig();
            expresion();
        }
    }

    // <DisySig> -> + | -
    public void disySig() {
        if (tok == ALexico.SUMA || tok == ALexico.RESTA) {
            match(tok);
        } else {
            System.out.println("Error: Se esperaba '+' o '-'.");
        }
    }

    // <Termino> -> <Factor> <Termino_prima>
    public void termino() {
        factor();
        terminoPrima();
    }

    // <Termino_prima> -> <DisySigno> <Termino> | ∅
    public void terminoPrima() {
        if (tok == ALexico.MULT || tok == ALexico.DIV) {
            disySigno();
            termino();
        }
    }

    // <DisySigno> -> * | /
    public void disySigno() {
        if (tok == ALexico.MULT || tok == ALexico.DIV) {
            match(tok);
        } else {
            System.out.println("Error: Se esperaba '*' o '/'.");
        }
    }

    // <Factor> -> (<Expresion>) | id | num
    public void factor() {
        if (tok == ALexico.PARENTESIS_ABRE) {
            match(ALexico.PARENTESIS_ABRE);
            expresion();
            match(ALexico.PARENTESIS_CIERRA);
        } else if (tok == ALexico.ID) {
            match(ALexico.ID);
        } else if (tok == ALexico.NUM) {
            match(ALexico.NUM);
        } else {
            System.out.println("Error: Se esperaba '(', ID o NUM en Factor.");
        }
    }
}