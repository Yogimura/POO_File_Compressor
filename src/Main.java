import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.io.File;

public class Main {
    //static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Unzipped prueba = new Unzipped("Fileproves\\probing");

        //System.out.println(prueba.getContent());
        //System.out.println(prueba.getSize());

        //HashMap<String, Integer> set = new FileManagement(prueba).getReps(prueba.words);

        //Zipped golang = prueba.IOzip(prueba.carry, set);

        //System.out.println(String.join(" | ", prueba.words));

        //System.out.println(golang.getContent());

        //System.out.println(golang.getSize());

        Zipped archivo = new Zipped("Fileproves\\probing.ziped");
    }
}