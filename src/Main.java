import java.util.*;

public class Main {
    //static Scanner lector = new Scanner(System.in);
    //static String[] Caracteres = new String[] {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};

    public static ArrayList<String> getRepsWords(String[] base){
        String comodin;
        ArrayList<String> repetidas = new ArrayList<>();

        for(int i = 0; i < base.length; i++){
            comodin = base[i];
            for(int o = i+1; o < base.length; o++){
                if(base[o].equals(comodin) && !repetidas.contains(comodin)){
                    repetidas.add(comodin);
                    break;
                }
            }
        }

        return repetidas;
    }
    public static void main(String[] args) {
        String texto;
        String resultado;

        String[] palabras;

        LinkedList<String> repspile;

        ArrayList<String> repswords;
        Map<Integer, String> coordenadas = new HashMap<>();


        texto = "Pedro Almanzar del orbe porta un orbe cuyo propietario era el abuelo de su abuelo Almanzar del orbe";

        System.out.println(texto);

        resultado = texto;
        palabras = texto.split(" ");

        repswords = new ArrayList<>(getRepsWords(palabras));

        repspile = new LinkedList<>(repswords);

        for(int i = 0; i < palabras.length; i++) {
            for(String repetida: repswords){
                if(palabras[i].equals(repetida)){
                    coordenadas.put(i, repetida);
                }
            }
        }

        System.out.println(resultado);
    }
}