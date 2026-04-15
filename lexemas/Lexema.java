package PruebasRepositorio2026.lexemas;

public class Lexema {
    private String dato;
    private String tipo;

    // Constructor
    public Lexema(String dato, String tipo) {
        this.dato = dato;
        this.tipo = tipo;
        this.token = token;
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
        return "[" + dato + "\t" + tipo + "]";
    }
        
    
}
