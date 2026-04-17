package analizadorlexico.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import lexemasprueba.Lexema;
import java.util.ArrayList;

public class ProcesadorTexto {

    private int erroresLexicos;

    public String buscarIdentificadores(String texto) {

        erroresLexicos = 0;

        if (texto == null || texto.trim().isEmpty()) {
            return "No hay texto para analizar. Abre un archivo";
        }

        StringBuilder resultados = new StringBuilder();
        int cantIDs = 0, cantNum = 0, cantLexe = 0, cantErrores = 0;

        ArrayList<Lexema> listaLexemas = new ArrayList<>();

        // TU REGEX EXACTA (Solo cambié /s por \\s+ para el grupo 5 de espacios)
        String regex = "([A-Za-z]\\w*)|" + // Grupo 1: Identificadores
                "(0|[1-9]\\d*)|" + // Grupo 2: Numeros
                "(==|!=|<=|>=|<|>|=|\\+|-|\\*|/)|" + // Grupo 3: Logicos y Aritméticos
                "(\\.|,|;|\\(|\\))|" + // Grupo 4: Puntuacion
                "(\\s+)|" + // Grupo 5: Espacios
                "(.)"; // Grupo 6: ERRORES

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {

            String hallazgo = matcher.group();

            // 1. IDENTIFICADORES Y PALABRAS RESERVADAS
            if (matcher.group(1) != null) {
                cantIDs++;
                listaLexemas.add(new Lexema(hallazgo, "ID"));
                continue;
            }
            // 2. NUMEROS
            if (matcher.group(2) != null) {
                cantNum++;
                listaLexemas.add(new Lexema(hallazgo, "Num"));
                continue;
            }

            // 3. OPERADORES Y PUNTUACION (Grupos 3 y 4)
            if (matcher.group(3) != null || matcher.group(4) != null) {
                cantLexe++;
                listaLexemas.add(new Lexema(hallazgo, "Simb"));
                continue;
            }
            
            // 4. ESPACIOS (Se ignoran)
            if (matcher.group(5) != null) {
                continue;
            }

            // 5. ERRORES LEXICOS (Solo lo que cae en el Grupo 6)
            if (matcher.group(6) != null) {

                cantErrores++;
                erroresLexicos++;
                listaLexemas.add(new Lexema(hallazgo, "Error"));

                int respuesta = JOptionPane.showOptionDialog(
                        null,
                        "Se encontro un error lexico: " + hallazgo +
                                "\n¿Quieres terminar o seguir?",
                        "Advertencia de Error",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        new Object[] { "Terminar", "Seguir" },
                        "Seguir");

                if (respuesta == JOptionPane.YES_OPTION) {
                    resultados.append("\n-- Analisis Detenido Por el Usuario --\n");
                    break;
                }

                continue;
            }
        }
        
        // AGREGAR FORMATO DE TABLA AL RESULTADO FINAL
        for (Lexema lex : listaLexemas) {
            resultados.append(lex.toString()).append("\n");
        }

        return " IDs/Palabras: " + cantIDs +
                " | Números: " + cantNum +
                " | Símbolos: " + cantLexe +
                " | Errores: " + cantErrores +
                "\n\nTabla de Símbolos en orden:\n"
                + resultados.toString();
    }

    public int getErroresLexicos() {
        return erroresLexicos;
    }
}