import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Component;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProcesadorTexto {
    //Metodo para abrir el buscador de archivos y leer el texto
    public String leerArchivoConFiltro(Component padre){
        JFileChooser fileChooser= new JFileChooser();
        //Filtro para mostrar solo archivos que nos interesan
        FileNameExtensionFilter filtro= new FileNameExtensionFilter("Archivos de texto","txt","java","html","css");
        fileChooser.setFileFilter(filtro);
        int respuesta= fileChooser.showOpenDialog(padre);
        if(respuesta == JFileChooser.APPROVE_OPTION){
            File archivoSeleccionado = fileChooser.getSelectedFile();
            StringBuilder contenido = new StringBuilder();

            try (BufferedReader br= new BufferedReader(new FileReader(archivoSeleccionado))){
                String linea;
                while ((linea= br.readLine()) != null){
                    //Agrega la linea y un salto de linea
                    contenido.append(linea).append("\n");
                }
                return contenido.toString();
            } catch (IOException e){
                return "Error al leer el archivo: "+e.getMessage();
            }
        }
        //Retorna null si el usuario cierra la ventana sin elegir nada
        return null;
    }
    //Metodo que aplica el RegEx a el texto
    public String buscarIdentificadores(String texto){
        if (texto == null || texto.trim().isEmpty()){
            return "No hay texto para analizar. Abre un archivo";
        }
        //Separamos todo el texto por espacios, saltos de linea o tabulaciones
        String[] palabras = texto.split("\\s+");
        //RegEx para Identificadores
        String regexIdentificador= "[A-Za-z]\\w*";

        int contador=0;
        StringBuilder resultados= new StringBuilder();
        for(String palabra : palabras){
            if (palabra.matches(regexIdentificador)){
                contador++;
                resultados.append(palabra).append("\n");
            }
        }
        return "Se encontraron "+contador+" identificadores validos:\n\n"+resultados.toString();
    }
}
