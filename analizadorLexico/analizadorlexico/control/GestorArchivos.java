package analizadorlexico.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GestorArchivos {

    public String leerArchivoConFiltro(Component padre){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "Archivos de texto","txt","java","html","css");
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
}