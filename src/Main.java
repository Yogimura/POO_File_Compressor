import java.util.*;

public class Main {
    static Scanner lector = new Scanner(System.in);
    static String[] Caracteres = new String[] {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};
    public static void main(String[] args) {
        //Pedro Almanzar del orbe porta un orbe cuyo propietario era el abuelo de su abuelo Almanzar del orbe
        String texto;
        String resultado;

        System.out.println("Ingrese el texto a comprimir");

        texto = lector.nextLine();

        resultado = texto;

        String[] palabras = texto.split(" ");
        ArrayList<String> repetidas = new ArrayList<>();

        String comodin;

        for(int i = 0; i < palabras.length; i++){
            comodin = palabras[i];
            for(int o = i+1; o < palabras.length; o++){
                if(palabras[o].equals(comodin) && !repetidas.contains(comodin)){
                    repetidas.add(comodin);
                    break;
                }
            }
        }

        for(int i = 0; i < repetidas.size(); i++) {
            resultado = resultado.replace(repetidas.get(i), Caracteres[i]);
        }

        int lastreplace = 0;
        for (String caracter : Caracteres) {
            if (resultado.lastIndexOf(caracter) > lastreplace) {
                lastreplace = resultado.lastIndexOf(caracter);
            }
        }

        String redunds = resultado.substring(resultado.indexOf(Caracteres[0]), lastreplace + 1);
        String shortredunds = redunds.replaceAll(" ", "");

        System.out.println(shortredunds);
        resultado = resultado.replace(redunds, shortredunds);

        System.out.println(resultado);

        //En la proxima intenta reemplazar cada espacio en blanco
    }
}