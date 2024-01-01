import java.util.*;

public class Main {
    static Scanner lector = new Scanner(System.in);
    static String[] Caracteres = new String[] {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};
    public static void main(String[] args) {
        String texto;
        String resultado;
        String comodin;

        String[] palabras;

        ArrayList<String> repetidas = new ArrayList<>();

        LinkedList<String> repspile;

        Map<Integer, String> coordenadas = new HashMap<>();


        texto = "Pedro Almanzar del orbe porta un orbe cuyo propietario era el abuelo de su abuelo Almanzar del orbe";

        System.out.println(texto);

        resultado = texto;
        palabras = texto.split(" ");

        for(int i = 0; i < palabras.length; i++){
            comodin = palabras[i];
            for(int o = i+1; o < palabras.length; o++){
                if(palabras[o].equals(comodin) && !repetidas.contains(comodin)){
                    repetidas.add(comodin);
                    break;
                }
            }
        }

        repspile = new LinkedList<>(repetidas);

        for(int i = 0; i < palabras.length; i++) {
            for(String repetida: repetidas){
                if(palabras[i].equals(repetida)){
                    coordenadas.put(i, repetida);
                }
            }
        }

        System.out.println(resultado);
    }
}