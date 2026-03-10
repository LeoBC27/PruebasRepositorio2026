package analizadorlexico.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesadorTexto {

    public String buscarIdentificadores(String texto){

        if (texto == null || texto.trim().isEmpty()){
            return "No hay texto para analizar. Abre un archivo";
        }

        StringBuilder resultados = new StringBuilder();
        int cantIDs = 0;
        int cantNum = 0;

        String regex = "([A-Za-z]\\w*)|(0|[1-9]\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {

            String hallazgo = matcher.group();

            if (matcher.group(1) != null) {
                cantIDs++;
                resultados.append("Identificador: ").append(hallazgo).append("\n");
            } 
            else if (matcher.group(2) != null) {
                cantNum++;
                resultados.append("Número: ").append(hallazgo).append("\n");
            }
        }

        return "IDs: " + cantIDs + " | Números: " + cantNum +
               "\n\nElementos encontrados en orden:\n" + resultados.toString();
    }
}