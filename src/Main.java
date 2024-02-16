import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.io.File;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Zipped archivo1 = new Zipped("Fileproves\\Gas.ziped");
        HashMap<String, Character> al = new HashMap<>();
        AFile archivo2 = new Unzipped(archivo1.carry, archivo1.content);
    }
}