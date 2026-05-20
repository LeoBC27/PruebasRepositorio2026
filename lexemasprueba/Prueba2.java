package lexemasprueba;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prueba2 {

    public static void main(String[] args) {

        String regex = "([A-Za-z]\\w*)|" + //
                "(0|[1-9]\\d*)|" + //
                "(==|!=|<=|>=|<|>|=|\\+|-|\\*|/)|" + //
                "(\\.|,|;|\\(|\\))|" + //
                "(/s)|" + //
                "(.)";

        String texto = ("const x=100,y=10.21;var a___2,b_c_2_t,059\n" + //
                "a__2<<===!==xy-yx==>=>>100000000066\n" + //
                "if-while+for*then/do%to|downto\n" + //
                "(x_nueva(y_vieja))(b_c_2_t.\n" + //
                "fin_2");
                
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        ArrayList<Lexema> lexemas = new ArrayList<>();
        while (matcher.find()) {

            String hallazgo = matcher.group();
            if (matcher.group(1) != null) {

                // Agregar a identificadores
                lexemas.add(new Lexema(hallazgo, "ID"));
                continue; // continue hace un codigo elegante, manda al principio del while para que se
                          // vuelva a repetir
            }
            if (matcher.group(2) != null) {
                lexemas.add(new Lexema(hallazgo, "Num"));
                continue;
            }
            if (matcher.group(6) != null) {
                lexemas.add(new Lexema(hallazgo, "Error"));
            }
            // Continuar con los demas grupos
        }
        for (Lexema e : lexemas) {
            System.out.println(e);

        }
    }
}











/*
package analizadorlexico.control;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesadorTexto {

    public void analizar(String texto) {

        ArrayList<String> binarios = new ArrayList<>();
        ArrayList<String> decimales = new ArrayList<>();
        ArrayList<String> octales = new ArrayList<>();
        ArrayList<String> hexadecimales = new ArrayList<>();

        String regex =
        "\\b([01]+)\\b|" +        // Grupo 1: Binarios
        "\\b([1-9]\\d*)\\b|" +    // Grupo 2: Decimales
        "\\b(0[0-7]+)\\b|" +      // Grupo 3: Octales
        "\\b(0x[0-9A-F]+)\\b|" +  // Grupo 4: Hexadecimales
        "([0-9][0-9a-zA-Z.]+)";   // Grupo 5: Invalidos
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {

            String token = matcher.group();

            if (matcher.group(1) != null) {
                binarios.add(token);
                continue;
            }

            // DECIMALES
            if (matcher.group(2) != null) {
                decimales.add(token);
                continue;
            }

            // OCTALES
            if (matcher.group(3) != null) {
                octales.add(token);
                continue;
            }

            // HEXADECIMALES
            if (matcher.group(4) != null) {
                hexadecimales.add(token);
                continue;
            }

            
            if (matcher.group(5) != null) {
                
            }
        }


        System.out.println("\nRESULTADOS:");
        System.out.println("Binarios: " + binarios);
        System.out.println("Decimales: " + decimales);
        System.out.println("Octales: " + octales);
        System.out.println("Hexadecimales: " + hexadecimales);
    }
        // --- FORMA MÁS FÁCIL DE MOSTRAR ERRORES ---
        System.out.println("\nErrores:");
        
        // 1. Quitamos de la entrada original todo lo que hizo match con tu regex
        String textoSobrante = entrada.replaceAll(regex, " "); 
        
        // 2. Separamos ese texto sobrante por los espacios y lo imprimimos directo
        for (String error : textoSobrante.trim().split("\\s+")) {
            if (!error.isEmpty()) {
                System.out.println(error);
            }
        }
    }
}


package analizadorlexico;
import  analizadorlexico.control.ProcesadorTexto;

public class Main {

    public static void main(String[] args) {

        String entrada =
            "0654+0xA123 1010-42 0777*0x1A3 999/0b1010 "
          + "05+0x7F 0123+076 08+079 0xGG";

        new ProcesadorTexto().analizar(entrada);
    }
}


fechabasica
\b\d{2}/\d{2}/\d{4}\b
fechavalida
\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\d{4}\b
//String regex =("(0[xX])[0-9A-Fa-f]+"); //numero hexa
             //String regex =("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"); //correo
              //String regex =("([A-Za-z][\\w]*)");//identificador
             // String regex =("(((25[0-4])|(2[0-4]\\d)|(1?\\d?[0-9])\\.)){3}"); ///identificar ip
              //String regex =("([ZY][A-Z]{2}\\-\\d{3}\\-[A-Z])"); ///identificar placas
             String regex =("@[\\w]{4,15}"); //identificar usuarios de x

*/
