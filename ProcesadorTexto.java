import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProcesadorTexto {
    
    // 1. Método para leer archivos
    public String leerArchivoConFiltro(Component padre){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto","txt","java","html","css");
        fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showOpenDialog(padre);
        if(respuesta == JFileChooser.APPROVE_OPTION){
            File archivoSeleccionado = fileChooser.getSelectedFile();
            StringBuilder contenido = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(archivoSeleccionado))){
                String linea;
                while ((linea = br.readLine()) != null){
                    contenido.append(linea).append("\n");
                }
                return contenido.toString();
            } catch (IOException e){
                return "Error al leer el archivo: " + e.getMessage();
            }
        }
        return null;
    }
    public String buscarIdentificadores(String texto){
        if (texto == null || texto.trim().isEmpty()){
            return "No hay texto para analizar. Abre un archivo";
        }
        StringBuilder resultados = new StringBuilder();
        int cantIDs = 0;
        int cantNum = 0;
        String regex = "([A-Za-z]\\w*)|([0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()) {
            String hallazgo = matcher.group();
            // Si coincide con el Grupo 1 (Identificadores)
            if (matcher.group(1) != null) {
                cantIDs++;
                resultados.append("Identificador: ").append(hallazgo).append("\n");
            } 
            // Si coincide con el Grupo 2 (Números)
            else if (matcher.group(2) != null) {
                cantNum++;
                resultados.append("Número: ").append(hallazgo).append("\n");
            }
        }
        return "IDs: " + cantIDs + " | Números: " + cantNum + 
               "\n\nElementos encontrados en orden:\n" + resultados.toString();
    }
}