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
    public String buscarIdentificadores(String texto) {
    if (texto == null || texto.trim().isEmpty()) {
        return "No hay texto para analizar. Abre un archivo";
    }
    StringBuilder resultados = new StringBuilder();
    int contador = 0;
    int cantIDs = 0;    // Contador para identificadores
    int cantNum = 0;    // Contador para números
    
    String regex = "([a-zA-Z][a-zA-Z0-9]*)|([0-9]+)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(texto);
    
    while (matcher.find()) {
        contador++;
        String hallazgo = matcher.group();
        
        if (Character.isDigit(hallazgo.charAt(0))) {
            cantNum++; // Aumenta contador de números
            resultados.append("Número: ").append(hallazgo).append("\n");
        } else {
            cantIDs++; // Aumenta contador de IDs
            resultados.append("Identificador: ").append(hallazgo).append("\n");
        }
    }
    
    return "Identificadores: " + cantIDs + " | Números: " + cantNum + " | Total: " + contador + 
           "\n\nSe encontraron en orden:\n" + resultados.toString();
}}