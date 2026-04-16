package PruebasRepositorio2026.lexemas;

public class Lexema {
    private String dato;
    private String tipo;
    private int token;

    // Constructor
    public Lexema(String dato, String tipo) {
        this.dato = dato;
        this.tipo = tipo;
        if (tipo.equals("ID")){
            this.token = PruebasClase.esReservada(dato);
            this.tipo=(token==14)?tipo:"PR";
        } else{
            this.token = 0;
        }
    }
    //getters and setters
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "[" + dato + "\t" + tipo + "\t" + token + "\t" + "]";
    }
        
    
}
