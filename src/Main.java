import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main {
    //static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        Unzipped prueba = new Unzipped("Fileproves\\probing");

        System.out.println(prueba.getContent());
        System.out.println(prueba.getSize());

        HashMap<String, Integer> set = prueba.getReps();

    }
}