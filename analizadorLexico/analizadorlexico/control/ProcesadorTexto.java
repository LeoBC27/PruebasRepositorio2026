package analizadorlexico.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class ProcesadorTexto {

    public String buscarIdentificadores(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "No hay texto para analizar. Abre un archivo";
        }

        StringBuilder resultados = new StringBuilder();
        int cantIDs = 0;
        int cantNum = 0;
        int cantLexe = 0;
        int cantErrores = 0;

        // Lista para guardar lexemas
        ArrayList<String> listaLexemas = new ArrayList<>();

        String regex = "([A-Za-z]\\w*)|(0|[1-9]\\d*)|(==|!=|<=|>=|<|>|=|\\+|-|\\*|\\.|,|;|\\(|\\))|(%|/)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {

            String hallazgo = matcher.group();

            if (matcher.group(1) != null) {
                cantIDs++;
                resultados.append("Identificador: ").append(hallazgo).append("\n");
            } else if (matcher.group(2) != null) {
                cantNum++;
                resultados.append("Número: ").append(hallazgo).append("\n");
            } else if (matcher.group(3) != null) {
                cantLexe++;

                // SOLO símbolos
                String nombreSimb = nombreLexema(hallazgo);
                listaLexemas.add(nombreSimb + ": " + hallazgo);
                resultados.append(nombreSimb).append(": ").append(hallazgo).append("\n");
            } else if (matcher.group(4) != null){
                cantErrores++;
                resultados.append(">>Error Lexico: Simbolo no permitido ").append(hallazgo).append(" >>\n");
                //Ventana de Advertencia
                int respuesta = JOptionPane.showOptionDialog(null, "Se encontro un error lexico: "+ hallazgo
                + "\n¿Quieres terminar o seguir?", "Advertencia de Error", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null, new Object[]{"Terminar","Seguir"}, "Seguir");
                if (respuesta == JOptionPane.YES_OPTION){
                    resultados.append("\n-- Analisis Detenido Por el Usuario --\n");
                    break;
                }
            }
        }
        return "IDs: " + cantIDs + " | Números: " + cantNum + " | Lexemas: " + cantLexe + " | Errores: " + cantErrores +
                "\n\nElementos encontrados en orden:\n" + resultados.toString();
    }

    private String nombreLexema(String simbolo) {
        switch (simbolo) {
            case "==":
                return "IGUAL_IGUAL";
            case "!=":
                return "DIFERENTE_DE";
            case "<=":
                return "MENOR_IGUAL_QUE";
            case ">=":
                return "MAYOR_IGUAL_QUE";
            case "<":
                return "MENOR_QUE";
            case ">":
                return "MAYOR_QUE";
            case "=":
                return "IGUAL";
            case "+":
                return "SUMA";
            case "-":
                return "RESTA";
            case "*":
                return "MULT";
            case ".":
                return "PUNTO";
            case ",":
                return "COMA";
            case ";":
                return "PUNTO_COMA";
            case "(":
                return "PARENTESIS_ABRE";
            case ")":
                return "PARENTESIS_CIERRA";
            default:
                return "DESCONOCIDO";
        }
    }
}