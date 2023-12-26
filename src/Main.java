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
        LinkedList<String> repspile = new LinkedList<>(repetidas);
        Map<Integer, String> coordenadas = new HashMap<>();

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