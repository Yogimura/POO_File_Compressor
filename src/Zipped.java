import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Zipped extends AFile implements Izipper<Unzipped>{
    HashMap<String, Integer> PositionMap;
    public Zipped(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public Unzipped IOzip(File_Info ID, HashMap<String, Integer> wordmap) {
        return null;
    }
}