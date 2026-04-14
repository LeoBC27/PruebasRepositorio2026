import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prueba2 {


  
    
    public static void main(String[] args) {
        
    String regex = "([A-Za-z]\\w*)|"+//
    "(0|[1-9]\\d*)|"+//
    "(==|!=|<=|>=|<|>|=|\\+|-|\\*|/)|"+//
    "(\\.|,|;|\\(|\\))|"+//
    "(/s)|"+//
    "(.)";
          String texto = ("const x=100,y=10.21;var a___2,b_c_2_t,059\n" + //
                "a__2<<===!==xy-yx==>=>>100000000066\n" + //
                "if-while+for*then/do%to|downto\n" + //
                "(x_nueva(y_vieja))(b_c_2_t.\n" + //
                "fin_2");
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(texto);
    ArrayList <String> lexemas = new ArrayList<>();
        while (matcher.find()) {

            String hallazgo = matcher.group();
            if (matcher.group(1) != null) {

                // Agregar a identificadores 
                lexemas.add(hallazgo);
            } 
            if (matcher.group(6)!= null) {
                System.out.println("ERROR");
            }

        } for (String e : lexemas) {
            System.out.println(e);
            
        }
    }
}
