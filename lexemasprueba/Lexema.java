package lexemasprueba;

public class Lexema {
    private String dato;
    private String tipo;
    private int token;

    public Lexema(String dato, String tipo) {
        this.dato = dato;
        this.tipo = tipo;
        
        if (tipo.equals("ID")) {
            this.token = ALexico.esReservada(dato);
            this.tipo = (this.token == ALexico.ID) ? "ID" : "PR";
        } else if (tipo.equals("Num")) {
            this.token = ALexico.NUM;
        } else if (tipo.equals("Error")) {
            this.token = 0;
        } else {
            // Es un símbolo
            this.tipo = "Simb";
            this.token = ALexico.obtenerTokenSimbolo(dato);
        }
    }

    @Override
    public String toString() {
        return "[ " + dato + "\t" + tipo + "\t" + token + "\t]";
    }
}