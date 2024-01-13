import java.io.FileNotFoundException;

public class Main {
    //static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        Unzipped prueba = new Unzipped("Fileproves\\probing");

        System.out.println(prueba.getContent());

        prueba.getReps();

    }
}