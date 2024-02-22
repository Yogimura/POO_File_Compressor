import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        System.out.println("Bienvenido al sistema de compresion de archivos");
        System.out.println("Todos los archivos que se encuentren dentro de esta carpeta se comprimiran o de descomprimiran segun los archivos esten compresos o no.");
        System.out.println("Quiere usted proceder?\n1. Si\n2. No\n0. Salir");
        int sl = -1;
        int i = 0;
        do {
            if(i > 0){
                System.out.println("Ingrese una opcion valida");
            }
            try {
                sl = lector.nextInt();
            } catch (InputMismatchException _) {
                lector.nextLine();
            }
            i++;
        } while (sl <= -1 || sl >= 3);

    }

    public static void cleanScreen(long milis) throws InterruptedException{
        Thread.sleep(milis);
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }


}